package com.example.lab6;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Адаптивный тест</title><style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; }");
        out.println("h2 { text-align: center; color: #333; }");
        out.println("form { width: 50%; margin: 30px auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        out.println("input[type='radio'] { margin-right: 10px; }");
        out.println("button { width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer; }");
        out.println("button:hover { background-color: #45a049; }");
        out.println("</style></head><body>");
        out.println("<h2>Адаптивный тест</h2>");
        out.println("<form action='/lab6_war/test' method='POST'>");

        out.println("<p>1. Какой из языков не является языком программирования?</p>");
        out.println("<input type='radio' name='q1' value='Java'/> Java<br>");
        out.println("<input type='radio' name='q1' value='PHP'/> PHP<br>");
        out.println("<input type='radio' name='q1' value='Go'/> Go<br>");
        out.println("<input type='radio' name='q1' value='HTML'/> HTML<br><br>");

        out.println("<p>2. В каком году создан язык Java?</p>");
        out.println("<input type='radio' name='q2' value='1990'/> 1990 год<br>");
        out.println("<input type='radio' name='q2' value='1995'/> 1995 год<br>");
        out.println("<input type='radio' name='q2' value='1998'/> 1998 год<br>");
        out.println("<input type='radio' name='q2' value='1988'/> 1988 год<br><br>");

        out.println("<p>3. Что такое сервлет?</p>");
        out.println("<input type='radio' name='q3' value='Класс'/> Класс<br>");
        out.println("<input type='radio' name='q3' value='Объект'/> Объект<br>");
        out.println("<input type='radio' name='q3' value='Интерфейс'/> Интерфейс<br>");
        out.println("<input type='radio' name='q3' value='Метод'/> Метод<br><br>");

        out.println("<button type='submit'>Отправить</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer1 = request.getParameter("q1");
        String answer2 = request.getParameter("q2");
        String answer3 = request.getParameter("q3");
        int count = 0;
        if (answer1.equals("HTML")) count++;
        if (answer2.equals("1995")) count++;
        if (answer3.equals("Интерфейс")) count++;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Адаптивный тест: Результаты</title><style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; }");
        out.println("h2 { text-align: center; color: #333; }");
        out.println("input[type='radio'] { margin-right: 10px; }");
        out.println("button { width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer; }");
        out.println("button:hover { background-color: #45a049; }");
        out.println("</style></head><body>");
        out.println("<h2>Результаты теста</h2>");
        out.println("<p>Вопрос 1: " + answer1 + "</p>");
        out.println("<p>Вопрос 2: " + answer2 + "</p>");
        out.println("<p>Вопрос 3: " + answer3 + "</p>");
        out.println("<p>Правильных ответов: " + count + " из 3</p>");
        out.println("<a href='index.html'><button>Пройти тест снова</button></a>");
        out.println("</body></html>");
    }
}