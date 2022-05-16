package br.com.alura.forum.controller

@RestControlelr
@RequestMapping("/hello")
class HelloController {

    @GetMapping
    fun hello(): String {
        return "HELLo"
    }
}