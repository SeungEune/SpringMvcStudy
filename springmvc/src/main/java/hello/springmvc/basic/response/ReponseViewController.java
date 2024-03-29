package hello.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ReponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1()
    {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model)
    {
        model.addAttribute("data", "hello!! V2");
        return "response/hello";
    }

    //이 방법은 명시성이 떨어지므로 비추천함
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model)
    {
        model.addAttribute("data", "hello!! V3");
    }
}
