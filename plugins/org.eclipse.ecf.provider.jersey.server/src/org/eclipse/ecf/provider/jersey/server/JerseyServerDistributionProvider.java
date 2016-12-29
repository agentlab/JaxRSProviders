package org.eclipse.ecf.provider.jersey.server;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;

import org.eclipse.ecf.core.ContainerTypeDescription;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.provider.jaxrs.JaxRSContainerInstantiator;
import org.eclipse.ecf.provider.jaxrs.server.JaxRSServerContainer;
import org.eclipse.ecf.provider.jaxrs.server.JaxRSServerContainer.JaxRSServerRemoteServiceContainerAdapter.JaxRSServerRemoteServiceRegistration;
import org.eclipse.ecf.provider.jaxrs.server.JaxRSServerDistributionProvider;
import org.eclipse.ecf.remoteservice.RSARemoteServiceContainerAdapter.RSARemoteServiceRegistration;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.Parameter;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceMethod;
import org.glassfish.jersey.servlet.ServletContainer;
import org.osgi.service.http.HttpService;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.IntegerMemberValue;

public class JerseyServerDistributionProvider extends JaxRSServerDistributionProvider {

	public static final String JERSEY_SERVER_CONFIG_NAME = "ecf.jaxrs.jersey.server";

	public static final String URL_CONTEXT_PARAM = "urlContext";
	public static final String URL_CONTEXT_DEFAULT = System
			.getProperty(JerseyServerContainer.class.getName() + ".defaultUrlContext", "http://localhost:8080");
	public static final String ALIAS_PARAM = "alias";
	public static final String ALIAS_PARAM_DEFAULT = "/org.eclipse.ecf.provider.jersey.server";

	public JerseyServerDistributionProvider() {
		super();
	}

	public void activate() throws Exception {
		setName(JERSEY_SERVER_CONFIG_NAME);
		setInstantiator(new JaxRSContainerInstantiator(JERSEY_SERVER_CONFIG_NAME) {
			@Override
			public IContainer createInstance(ContainerTypeDescription description, Map<String, ?> parameters,
					Configuration configuration) {
				String urlContext = getParameterValue(parameters, URL_CONTEXT_PARAM, URL_CONTEXT_DEFAULT);
				String alias = getParameterValue(parameters, ALIAS_PARAM, ALIAS_PARAM_DEFAULT);
				return new JerseyServerContainer(urlContext, alias,
						(ResourceConfig) ((configuration instanceof ResourceConfig) ? configuration : null));
			}
		});
		setDescription("Jersey Jax-RS Server Provider");
		setServer(true);
	}

	public class JerseyServerContainer extends JaxRSServerContainer {

		private ResourceConfig configuration;

		public JerseyServerContainer(String urlContext, String alias, ResourceConfig configuration) {
			super(urlContext, alias);
			this.configuration = configuration;
		}

		protected ResourceConfig createResourceConfig(final RSARemoteServiceRegistration registration) {
			if (this.configuration == null) {
				return ResourceConfig.forApplication(new Application() {
					/*@Override
					public Set<Class<?>> getClasses() {
						Set<Class<?>> results = new HashSet<Class<?>>();
						results.add(registration.getService().getClass());
						return results;
					}*/

					@Override
					public Set<Object> getSingletons() {
						Set<Object> results = new HashSet<>();
						results.add(registration.getService());
						return results;
					}
				});
			}
			return this.configuration;
		}

		@Override
		protected Servlet createServlet(JaxRSServerRemoteServiceRegistration registration) {
			ResourceConfig rc = createResourceConfig(registration);

			Class<?> implClass = registration.getService().getClass();
			for (Class<?> clazz : implClass.getInterfaces()) {
				if(clazz.getAnnotation(Path.class) == null) {
					final Resource.Builder resourceBuilder = Resource.builder();
					ResourceMethod.Builder methodBuilder;
//					Resource.Builder childResourceBuilder;
					String serviceResourcePath;
					String methodResourcePath;
					String methodName;

					//class
					serviceResourcePath = "/" + clazz.getSimpleName().toLowerCase() + "/{token}";
					resourceBuilder.path(serviceResourcePath);
					resourceBuilder.name(implClass.getName());

					//methods
                    for (Method method : implClass.getMethods())
                    {
                        if (method.getName() == "hello3")
                        {

                            ClassPool pool = ClassPool.getDefault();
                            CtClass liveClass = null;
                            try
                            {
                                pool.insertClassPath(new ClassClassPath(implClass));
                                pool.insertClassPath(new ClassClassPath(clazz));
                            //                                pool.importPackage("com.mycorp.examples.hello.IHello");

                                liveClass = pool.get("com.mycorp.examples.hello.ds.host.HelloComponent");
                            //                                liveClass = pool.get("com.mycorp.examples.hello.IHello");

                            //                                liveClass.toC


                                ClassFile ccFile = liveClass.getClassFile();
                                ConstPool constpool = ccFile.getConstPool();

                                AnnotationsAttribute attr =
                                    new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
                                javassist.bytecode.annotation.Annotation annot =
                                    new javassist.bytecode.annotation.Annotation("Test", constpool);
                                annot.addMemberValue("value", new IntegerMemberValue(ccFile.getConstPool(), 0));
                                attr.addAnnotation(annot);

                                CtMethod mthd = liveClass.getDeclaredMethod("hello3");

                                mthd.getMethodInfo().addAttribute(attr);

                                clazz = liveClass.toClass(ClassLoader.getSystemClassLoader());

                            }
                            catch (NotFoundException | CannotCompileException e)
                            {
                                e.printStackTrace();
                            //                                System.err.println("Template class not found.");
                            }



						if(Modifier.isPublic(method.getModifiers())) {
							methodName = method.getName().toLowerCase();
//							methodResourcePath = "/" + methodName + "/{token}";
//							childResourceBuilder = resourceBuilder.addChildResource(methodResourcePath);


							Annotation[][] parameterAnnotations = method.getParameterAnnotations();
							Class[] parameterTypes = method.getParameterTypes();

							int i=0;
							for(Annotation[] annotations : parameterAnnotations){
							  Class parameterType = parameterTypes[i++];

							  for(Annotation annotation : annotations){
//							    if(annotation instanceof MyAnnotation){
//							        MyAnnotation myAnnotation = (MyAnnotation) annotation;
							        System.err.println("value: " + annotation.toString());
//							    }
							  }
                            }

							if(method.getAnnotation(Path.class) == null) {
								if(method.getParameterCount() == 0) {
                                    methodBuilder = resourceBuilder.addMethod("GET");
								}
								else {
									if(methodName.contains("delete")) {
                                        methodBuilder = resourceBuilder.addMethod("DELETE");
									}
									else {
                                        methodBuilder = resourceBuilder.addMethod("POST");
									}
//									methodBuilder.consumes(MediaType.APPLICATION_JSON);//APPLICATION_JSON)TEXT_PLAIN_TYPE
								}

								Collection<Parameter> params = new ArrayList<>();

								if (method.getName() == "hello3") {
									Constructor<Parameter> constr;

//									Map<String, Object> valuesMap = new HashMap<>();
//									valuesMap.put("value", "token");
//
//									RuntimeAnnotations.putAnnotation(implClass, PathParam.class, valuesMap);

//									PathParam annotation = implClass..getAnnotation(TestAnnotation.class);
//								    System.out.println("TestClass annotation after:" + annotation);

									try {
										Constructor<?>[] constrs = Parameter.class.getDeclaredConstructors();
										//                                        constr = ParamBuilder.class.getDeclaredConstructor(Object.class, Object.class,
										//                                            Object.class, Object.class, Object.class, Object.class, boolean.class,
										//                                            Object.class);
										constr = (Constructor<Parameter>)constrs[1];
										constr.setAccessible(true);
										try {
											MyPathParam mpp = new MyPathParam();
											Annotation[] markers = new Annotation[] { new MyPathParam() };

											Parameter par = constr.newInstance(markers, new MyPathParam(), Parameter.Source.PATH, "token", String.class, String.class, false, null);
											params.add(par);
										}
										catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									catch (SecurityException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									methodBuilder
									.handlerParameters(params);
//									.handledBy(implClass, method);

								}

//                                List<ParamBuilder> params = ParamBuilder.create(implClass, implClass, method, false);

								methodBuilder.produces(MediaType.APPLICATION_JSON)//APPLICATION_JSON)
									//.handledBy(implClass, method)

									.handledBy(implClass, method)
//									.handlingMethod(method)
									.extended(false);
//									.handlerParameters(parameters);
							}
						}
                        }
					}
					final Resource resource = resourceBuilder.build();
					rc.registerResources(resource);
				}
			}
			return (rc != null) ? new ServletContainer(rc) : new ServletContainer();
		}

		@Override
		protected HttpService getHttpService() {
			return getHttpServices().get(0);
		}
	}
}
