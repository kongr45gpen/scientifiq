package com.kongr45gpen.scientifiq

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid


@Controller
class HtmlController {
    var logger: Logger = LoggerFactory.getLogger(HtmlController::class.java)

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Scientifiq"
        return "blog"
    }

    @PostMapping("/")
    fun blogSubmit(@Valid @ModelAttribute("response") response: SimpleResponse, model: Model, bindingResult: BindingResult): String {
        model["title"] = "Scientifiq Result"

        logger.info("Response = $response")

        if (bindingResult.hasErrors()) {
            logger.error("Big problem!")
        }

        return "blog"
    }
}