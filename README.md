REST API приложение на Spring Boot
В качестве классов-моделей выступают классы University и Faculty

**Зависимости, подключенные в проекте:**
 - spring-boot-starter-parent, version 2.7.13
 - spring-boot-starter-web
 - spring-boot-starter-data-jpa
 - lombok, version 1.18.26
 - jackson-databind version 2.14.2
 - mysql-connector-j
 - spring-boot-starter-test

### Для запуска приложения необходимо выполнить следующие операции:
 - загрузить зависимости проекта в pom-файле;
 - подключить к проекту базу данных MySQL;
 - в resources/application.properties ввести логин и пароль;
 - запустить файлы SQL-запросов из папки resources/sql, первым - 1_university, вторым - 2_faculty;
 - запустить проект.
Приложение готово к работе.

  - при помощи Postman импортировать коллекцию curl-запросов
из папки resources файл digitalchief_crud.postman_collection.json

**Перечень curl-запросов:**
### 1. Запросы для работы с объектом University.
**Создание объекта University:**
curl --location 'http://localhost:8080/api/universities/' \
--header 'Content-Type: application/json' \
--data '{
"nameUniversity": "BelGUT",
"numberOfStudentsUniversity": 3120,
"numberOfTeachersUniversity": 176,
"gpaUniversity": 6.5
}
'

**Получение из базы данных объекта University:**
  curl --location 'http://localhost:8080/api/universities/1'

**Получение всех объектов University из базы данных:**
curl --location 'http://localhost:8080/api/universities/all'

**Обновление объекта University:**
curl --location --request PUT 'http://localhost:8080/api/universities/' \
--header 'Content-Type: application/json' \
--data '{
"idUniversity": 1,
"nameUniversity": "GGU Scorina",
"numberOfStudentsUniversity": 4120,
"numberOfTeachersUniversity": 176,
"gpaUniversity": 6.6
}'

**Удаление объекта University из базы данных:**
curl --location --request DELETE 'http://localhost:8080/api/universities/1'

### 2.Запросы для работы с объектом Faculty.
**Создание объекта Faculty:**
curl --location 'http://localhost:8080/api/faculties/' \
--header 'Content-Type: application/json' \
--data '{
"nameFaculty":"Mechanical engineering",
"department": "Hydraulics",
"numberOfStudentsFaculty": 330,
"numberOfTeachersFaculty": 21,
"gpaFaculty": 7.0,
"idUniversity": 2
}'

**Получение из базы данных объекта Faculty**
curl --location 'http://localhost:8080/api/faculties/1'

**Получение всех объектов Faculty из базы данных:**
curl --location 'http://localhost:8080/api/faculties/all'

**Обновление объекта Faculty:**
curl --location --request PUT 'http://localhost:8080/api/faculties/' \
--header 'Content-Type: application/json' \
--data '{
"idFaculty": 1,
"nameFaculty":"Biology",
"department": "Chemistry",
"numberOfStudentsFaculty": 333,
"numberOfTeachersFaculty": 21,
"gpaFaculty": 7.0,
"idUniversity": 1
}'

**Удаление объекта Faculty из базы данных:**
curl --location --request DELETE 'http://localhost:8080/api/faculties/1'

