#RESTful Web Services

Social media application 

User -> Posts
#one-to-many relationship

- Retrieve all Users    - GET /users
- Create a User         - POST /users
- Retrieve one User     - GET /users/{userId} -> /users/1
- Delete a User         - DELETE /users/{userId} -> /users/1

- Retrieve all posts for a User - GET /users/{userId}/posts -> /users/1/posts
- Create a post for a User      - POST /users/{userId}/posts
- Retrieve details of a post    - GET /users/{userId}/posts/{postId} -> /users/1/posts/1