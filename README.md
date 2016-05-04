Highly configurable JAX-RS provider (Jersey + Jackson).

Application plug-ins should not have any hardcoded dependencies from ECF, JAX-RS or JSON.
* OSGi DS Services should not have any JAX-RS dependencies, annotations, properties
* DTO classes should be POJOs (or interface/implementation pair) and should not have any JSON dependencies or annotations
