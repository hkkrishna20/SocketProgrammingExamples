package kr.co.redbrush.webapp.controller.admin;

import kr.co.redbrush.webapp.controller.ControllerTestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class ChartControllerTest extends ControllerTestBase {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    private ChartController chartController = new ChartController();

    @Before
    public void before() {
    }

    @Test
    public void testCharts() throws Exception {
        String chartType = "general";
        String view = chartController.chart(model, chartType);

        assertThat("Unexpected value.", view, is("chart_" + chartType));
        assertThat("Unexpected value.", model.get("title"), is("Chart " + chartType));
    }
}
