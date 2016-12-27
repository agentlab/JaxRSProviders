/**
 *
 */
package org.eclipse.ecf.provider.jersey.server;

import java.lang.annotation.Annotation;

import javax.ws.rs.PathParam;

import org.glassfish.hk2.api.AnnotationLiteral;

/**
 * @author Zagrebaev_D
 *
 */
public class MyPathParam
    extends AnnotationLiteral<PathParam> implements PathParam {

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return "token";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "token";
	}

}
