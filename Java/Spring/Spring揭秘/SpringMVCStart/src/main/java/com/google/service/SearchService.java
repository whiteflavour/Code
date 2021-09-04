package com.google.service;

import com.google.model.Student;

public class SearchService {
    private MockStudentService mockStudentService;

    public Student getStudentById(Integer id) {
        return mockStudentService.getStudents().get(id - 1);
    }

    public MockStudentService getMockStudentService() {
        return mockStudentService;
    }

    public void setMockStudentService(MockStudentService mockStudentService) {
        this.mockStudentService = mockStudentService;
    }
}
