package sample;

import javafx.scene.chart.XYChart;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class FormulaController {
    /**
     * Creates a new Controller to control the logic of the quadratic equation
     * @param coefficients the set of coefficients of some quadratic equation
     */
    private final QuadraticCoefficients<Integer> coefficients;

    public FormulaController(QuadraticCoefficients<Integer> coefficients) {
        // TODO: Implement this constructor, which may involve creating `private final` fields for this class
        this.coefficients = coefficients;
    }

    /**
     * Returns the result of {@code f(x) = ax^2 + bx + c} for some value of {@code x}
     *
     * @apiNote You should not use {@link Math#sqrt(double)}
     *
     * @param x the x value
     * @return the y value
     */
    private int getY(int x) {
        // TODO: Implement this method. (Refer to the above JavaDoc comments).
        return (this.coefficients.getA() * x*x + this.coefficients.getB()*x + this.coefficients.getC());
    }

    /**
     * Returns a {@code List} of {@code XYChart.Data<Number, Number>} elements, which correspond
     * to each point that will be plotted on the graph.
     *
     * The {@code x} parameter should increment by {@code 1} for each data object, and the {@code y}
     * parameter should be the result of the quadratic equation applied to {@code x}. (using {@link #getY(int)})
     *
     * @param numberOfSamples the number of samples to compute. The resulting list's size should be equal to this number.
     *                        The x-values of the list should range from 0 (inclusive) up to but excluding {@code numberOfSamples}
     * @return the list of data points
     */
    public List<XYChart.Data<Number, Number>> getData(int numberOfSamples) {
        // TODO: Implement this method. (Refer to the above JavaDoc comments).
        List<XYChart.Data <Number, Number>> data = new ArrayList<>();

        for(int i = 0; i < numberOfSamples; i=i+1) {
            data.add(new XYChart.Data<>(i, getY(i)));
        }
        return data;
    }

    /**
     * Returns the formula formatted to a String. The format is {@code "ax^2 + bx + cx"}, where {@code a, b, c}
     * should be the coefficients of the formula.
     *
     * @return a formatted String
     */
    public String getFormulaString() {
        // TODO: Implement this method. (Refer to the above JavaDoc comments).
        return (this.coefficients.getA() + "x^2 + " + this.coefficients.getB() + "x + " + this.coefficients.getC() + "x");
    }
}

