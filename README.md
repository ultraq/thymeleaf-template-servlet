
Thymeleaf Template Servlet
==========================

[![GitHub Release](https://img.shields.io/github/release/ultraq/thymeleaf-template-servlet.svg?maxAge=3600)](https://github.com/ultraq/thymeleaf-template-servlet/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/nz.net.ultraq.thymeleaf/thymeleaf-template-servlet.svg?maxAge=3600)](http://search.maven.org/#search|ga|1|g%3A%22nz.net.ultraq.thymeleaf%22%20AND%20a%3A%22thymeleaf-template-servlet%22)
[![License](https://img.shields.io/github/license/ultraq/thymeleaf-template-servlet.svg?maxAge=2592000)](https://github.com/ultraq/thymeleaf-template-servlet/blob/master/LICENSE.txt)

Standalone servlet for serving Thymeleaf templates.

Mainly useful for testing or prototypes, this Servlet API 3.0 web fragment
project will map all \*.html requests to the Thymeleaf template of the same
name.


Installation
------------

Minimum of Java 7 and Thymeleaf 3 required.

### Standalone distribution
Copy the JAR from [the latest release bundle](https://github.com/ultraq/thymeleaf-template-servlet/releases),
placing it in the classpath of your application, or build the project from the
source code here on GitHub.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-template-servlet`
 - Version: (as per the badges above)


Usage
-----

Once your web app starts up (and provided you haven't disabled servlet
annotations), then the template servlet will start mapping any requests for HTML
files to templates of the same name in your project, eg: a request for `hello.html`
will then cause the template servlet to respond with `hello.html` from your web
app project folder.
