package com.admin;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminServiceJwtApplicationTests {

    @Test
    @Order(1)
    public void testgetallStudents() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/api/students")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(2)
    public void testAddStudent() {
    	String jsonbody="{\"student_firstname\":\"Hema\",\"student_lastname\":\"satyavada\",\"student_email\":\"teja@gmail.com\",\"dob\":\"2001/03/12\",\"student_password\":\"Hema\",\"student_class\":\"6\",\"gender\":\"male\",\"fathername\":\"kalyan\",\"mothername\":\"seeta\",\"fees\":\"false\",\"teacher_email\":\"veena@gmail.com\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8088/api/student")
                .then()
                .assertThat().statusCode(201)
                .extract().response().asString();
    }
    
    @Test
    @Order(3)
    public void testUpdateStudent() {
    	String jsonbody="{\"student_firstname\":\"Hemas\",\"student_lastname\":\"satyavada\",\"student_email\":\"teja@gmail.com\",\"dob\":\"2001/03/12\",\"student_password\":\"Hema\",\"student_class\":\"6\",\"gender\":\"male\",\"fathername\":\"kalyan\",\"mothername\":\"seeta\",\"fees\":\"false\",\"teacher_email\":\"veena@gmail.com\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .put("http://localhost:8088/api/student/teja@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    
    
  @Test
  @Order(4)
  public void testDeleteStudent() {
      String result=given()
              .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
              .when()
              .delete("http://localhost:8088/api/student/teja@gmail.com")
              .then()
              .assertThat().statusCode(200)
              .extract().response().asString();
  }
  
  @Test
  @Order(5)
  public void testgetallTeacher() {
      String result=given()
              .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
              .when()
              .get("http://localhost:8088/api/teachers")
              .then()
              .assertThat().statusCode(200)
              .extract().response().asString();
  }
  @Test
  @Order(6)
  public void testAddTeacher() {
  	String jsonbody="{\"teachername\":\"Shobha\",\"teacher_email\":\"shobha@gmail.com\",\"gender\":\"Female\",\"teacher_class\":\"5\",\"subject\":\"Maths\",\"phonenumber\":\"9087654567\"}";
      String res=given()
              .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
              .body(jsonbody)
              .when()
              .post("http://localhost:8088/api/teacher")
              .then()
              .assertThat().statusCode(201)
              .extract().response().asString();
  }
  @Test
  @Order(7)
  public void testUpdateTeacher() {
  	String jsonbody="{\"teachername\":\"Shobhas\",\"teacher_email\":\"shobha@gmail.com\",\"gender\":\"Female\",\"teacher_class\":\"5\",\"subject\":\"Maths\",\"phonenumber\":\"9087654567\"}";
    String res=given()
            .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
            .body(jsonbody)
              .when()
              .put("http://localhost:8088/api/teacher/shobha@gmail.com")
              .then()
              .assertThat().statusCode(200)
              .extract().response().asString();
  }  
  @Test
  @Order(8)
  public void testDeleteTeacher() {
      String result=given()
              .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
              .when()
              .delete("http://localhost:8088/api/teacher/shobha@gmail.com")
              .then()
              .assertThat().statusCode(200)
              .extract().response().asString();
  }
  
}