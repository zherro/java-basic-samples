## Scopes
Scope is used to specify the lifespan of an object. Any data stored in object is persisted throughout the scope of object and this data can be accessed any time within the scope as per requirement. Object that are bound to a particular scope called scoped object.

Data can be stored in scope as an attribute, attributes are name-value pair. name of attribute is type of String and value of attribute is type of Object. These are read and write attributes.

## Type of Servlet Scopes
There are mainly three types of servlet scopes

- Request scope
- Session scope
- Context scope

### 1. Request scope
- Data stored in HttpServletRequest will be available until request object destroyed
- Scope of such data called request scope
- Request data can be accessed by single user within same request and before sending the response

### 2. Session scope
- Data stored in HttpSession object will be available until session persists
- Scope of such data called session scope
- Session data can be accessed by single user across multiple requests
- User should belong to same session

### 3. Context scope
- Data stored in ServletContext will be available throughout the life of web application
- Scope of such data is called context scope
- Context data can be accessed by multiple users across multiple requests
