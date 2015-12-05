
Thymeleaf Template Servlet
==========================

Standalone servlet for serving Thymeleaf templates.

Mainly useful for testing or prototypes, this Servlet API 3.0 web fragment
project will map all \*.html requests to the Thymeleaf template of the same
name.

 - Current version: 1.0.0-SNAPSHOT
 - Released: ???


Installation
------------

Minimum of Java 7 and Thymeleaf 2.1 required.

### Standalone distribution
Copy the JAR from [the latest release bundle](https://github.com/ultraq/thymeleaf-template-servlet/releases),
placing it in the classpath of your application, or build the project from the
source code here on GitHub.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-template-servlet`
 - Version: `1.0.0-SNAPSHOT`


Usage
-----

Once your web app starts up (and provided you haven't disabled servlet
annotations), then the template servlet will start mapping any requests for HTML
files to templates of the same name in your project, eg: a request for `hello.html`
will then cause the template servlet to respond with `hello.html` from your web
app project folder.


Changelog
---------

### 1.0.0
 - Initial release
