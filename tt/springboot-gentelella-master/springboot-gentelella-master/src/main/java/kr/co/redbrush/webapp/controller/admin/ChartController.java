package kr.co.redbrush.webapp.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
@Slf4j
public class ChartController {

    @GetMapping({"/chart/{chartType}"})
    public String chart(Map<String, Object> model, @PathVariable("chartType") String chartType) {
        model.put("title", "Chart " + chartType);

        return "chart_" + chartType;
    }
}