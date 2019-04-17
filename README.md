In order to run this project, the initial steps would be:

1. If the project is showing the error, then we need to update the maven project.(right click project->Maven->Update project).

2. Now in order to run the project, Right click on the project -> Run as -> Spring Boot App

3. Now open postman/browser and build the url like:
    http://localhost:8070/users?searchParam=a&name=name&order=desc&limit=0&offset=3

    where search param,name,order,limit and offset are the parameters that were discussed.

    The output would be like:

    [
        {
            "id": 1,
            "name": "Anshul",
            "age": "23",
            "address": "abcd"
        },
        {
            "id": 2,
            "name": "Tarun",
            "age": "24",
            "address": "xyz"
        }
    ]

4. In application.properties file, I made connection to datatbase with schema as servicenow and table as user

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8