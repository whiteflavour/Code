package com.google;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

/**
 * Download and upload files.
 *
 * @author Liao
 * @date 2021-3-4
 */
@WebServlet(
        name = "uploadServlet",
        urlPatterns = {"/uploadServlet"}
)
@MultipartConfig(
        fileSizeThreshold = 5_242_880,
        maxFileSize = 20_971_520L,
        maxRequestSize = 41_943_040L
)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf8");
        PrintWriter out = response.getWriter();
        out.append("<form action=\"uploadServlet\" method=\"post\" enctype=\"multipart/form-data\"> \n")
                .append("Upload a file: <br/>\n")
                .append("<input type=\"file\" name=\"file1\"> <br/>\n")
                .append("<input type=\"submit\" value=\"Download\"> <br/>\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file1");
        InputStream inputStream = filePart.getInputStream();
        ServletOutputStream outputStream = response.getOutputStream();
        int read;
        byte[] bytes = new byte[1024];

        response.setHeader("Content-Disposition", "attachment; filename=" + filePart.getSubmittedFileName());
        response.setContentType("application/octet-stream");

        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
    }
}
