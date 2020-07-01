package View;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Edwin
 */

public class AHPResultsWindow extends JFrame {
  private JPanel panelGraphResults = new JPanel();
  private JScrollPane scrollpane = new JScrollPane();
  private JTextArea textareaResults = new JTextArea();

  public AHPResultsWindow(String outputlog, double results[]) {
    setTitle("Resultados AHP");
    setSize(1110, 580);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    showResultsInTextArea(outputlog);
    showGraphOfResults(results);
    setVisible(true);
  }

  public void showResultsInTextArea(String outputlog) {
    textareaResults = new JTextArea();
    textareaResults.append(
      "--------------------------------------------------------------------------------------------\n"
    );
    textareaResults.append("RESULTADOS: \n");
    textareaResults.append(
      "--------------------------------------------------------------------------------------------\n\n"
    );
    textareaResults.append(outputlog);
    scrollpane = new JScrollPane(textareaResults);
    scrollpane.setBounds(5, 5, 400, 500);
    getContentPane().add(scrollpane);
    add(scrollpane);
  }

  public void showGraphOfResults(double results[]) {
    panelGraphResults = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    getContentPane().add(panelGraphResults);
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    for (int i = 0; i < results.length; i++) {
      dataset.setValue(results[i] * 100, "A" + (i + 1), "A" + (i + 1));
    }
    JFreeChart chart = ChartFactory.createBarChart3D(
      "RESULTADO FINAL DE ALTERNATIVAS",
      "Alternativas",
      "% Prioridad",
      dataset,
      PlotOrientation.VERTICAL,
      true,
      true,
      false
    );
    chart.setBackgroundPaint(Color.WHITE);
    chart.getTitle().setPaint(Color.black);
    CategoryPlot p = chart.getCategoryPlot();
    p.setRangeGridlinePaint(Color.red);
    ChartPanel chartPanel = new ChartPanel(chart);
    panelGraphResults.add(chartPanel);
  }
}
