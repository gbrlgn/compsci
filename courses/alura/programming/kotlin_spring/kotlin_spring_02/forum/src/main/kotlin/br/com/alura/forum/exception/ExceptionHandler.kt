package br.com.alura.forum.exception

import br.com.alura.forum.dto.ErrorView

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        ex: NotFoundException,
        req: HttpServletRequest
    ): ErrorView {
        return ErrorView(
            status = HttpStatus.NOT_FOUND,
            error = HttpStatus.NOT_FOUND.name,
            message = ex.message,
            path = req.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
        ex: Exception,
        req: HttpServletRequest
    ): ErrorView {
        return ErrorView(
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = ex.message,
            path = req.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationError(
        ex: MethodArgumentNotValidException,
        req: HttpServletRequest
    ): ErrorView {
        val errorMessage = HashMap<String, String?>()
        ex.bindingResult.fieldErrors.forEach{
            e -> errorMessage.put(e.field, e.defaultMessage)
        }
        return ErrorView(
            status = HttpStatus.BAD_REQUEST,
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = req.servletPath
        )
    }
}