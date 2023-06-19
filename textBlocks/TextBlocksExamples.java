package org.example.textBlocks;

public class TextBlocksExamples {
    public static void main(String[] args) {
        String text= """  
                String message="Hello World";
                System.out.println(message);
                """; // """ must be on separate lines, and we can put anything in-between.
        System.out.println(text);
       String city="Bucharest";
        String query= """
                SELECT "EMP_ID, "LAST_NAME" FROM "EMPLOYEE_TB"
                WHERE "CITY" = %s
                ORDER BY "EMP_ID, "LAST_NAME";
                """.formatted(city);
        System.out.println(query);
        city="London";
        double salary=125_000.00;
        String query2= """
                SELECT "EMP_ID, "LAST_NAME" FROM "EMPLOYEE_TB"
                WHERE "CITY" = %s
                AND "SALARY">$%.2f
                ORDER BY "EMP_ID, "LAST_NAME";
                """.formatted(city,salary);
        System.out.println(query2);

        String html=""+
                "   <html>\n"+
                "      <body>\n"+
                "           <p>Hello World</p>\n"+
                "       </body>\n"+
                "   </html>";
        System.out.println(html.stripIndent());

        String j="JDK \\t  17";
        System.out.println(j);
        System.out.println(j.translateEscapes());

        String test= """
                
                JDK15
                JDK16
                JDK17
                \"""
                """;
        System.out.println(test);

        test= """
                
                JDK\s15
                JDK16\
                JDK17
                \"""
                """;
        System.out.println(test);
    }



}
