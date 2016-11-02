Highly configurable JAX-RS provider for OSGi declarative services.

External bundles: Jersey, Jackson, ECF.

The main goal is to make application plug-ins (bundles) as much reusable as possible.

As a result plug-ins should have minimum hardcoded dependencies:

* Application plug-ins with OSGi DS Services should not have any JAX-RS or ECF dependencies, annotations, properties and should know nothing about JAX-RS or ECF.
* DTO classes should be POJOs (or interface/implementation pair) and should not have any JSON dependencies or annotations.
