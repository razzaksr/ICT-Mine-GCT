package help;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class BMRTag extends SimpleTagSupport {
    private String gender;
    private double height; // in cm
    private double weight; // in kg
    private int age;

    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void doTag() throws IOException {
        double bmr;// default age

        if ("male".equalsIgnoreCase(gender)) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else if ("female".equalsIgnoreCase(gender)) {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        } else {
            getJspContext().getOut().println("Invalid gender specified.");
            return;
        }
        JspWriter out = getJspContext().getOut();
        out.println(String.format("Estimated BMR for %s: %.2f kcal/day", gender, bmr));
    }
}