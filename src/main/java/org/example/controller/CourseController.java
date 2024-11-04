package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.CourseDTO;
import org.example.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/course")
public class CourseController extends HttpServlet {
    CourseService courseService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CourseDTO courseById = courseService.getCourseById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(courseById);

        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        CourseDTO newCourse = objectMapper.readValue(sb.toString(), CourseDTO.class);

        CourseService courseService = new CourseService();
        courseService.save(1,"name");

        if (courseService != null) {
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write(objectMapper.writeValueAsString(newCourse));
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Course creation failed\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");


        String courseId = req.getPathInfo().substring(1);


        if (courseId == null || courseId.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Course ID is required\"}");
            return;
        }

        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        CourseDTO courseDTO = objectMapper.readValue(sb.toString(), CourseDTO.class);

        courseDTO.setId(Integer.parseInt(courseId));

        CourseService courseService = new CourseService();

        courseService.update(2,"name2");

        if (courseService != null) {
            resp.setStatus(HttpServletResponse.SC_OK); // 200 OK
            resp.getWriter().write(objectMapper.writeValueAsString(courseService));
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 Not Found
            resp.getWriter().write("{\"message\": \"User not found\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String courseId = req.getPathInfo().substring(1);

        if (courseId == null || courseId.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"User ID is required\"}");
            return;
        }


        CourseService courseService = new CourseService();
        courseService.delete(Integer.parseInt(courseId));

        if (courseService == null) {
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("{\"message\": \"User not found\"}");
        }
    }
}
