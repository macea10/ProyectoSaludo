package com.henrry.saludo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


/**
 * Clase de controlador que maneja solicitudes HTTP relacionadas con saludos.
 */
@RestController
@RequestMapping("/api")
public class SaludoController {

    /**
     * Fuente de mensajes internacionalizados.
     * Esta inyección permite acceder a mensajes traducidos según el locale del usuario.
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Obtiene un saludo según el locale del usuario.
     *
     * @param locale Código de locale proporcionado en el encabezado 'Accept-Language' de la solicitud.
     *               Si no se proporciona, se utiliza el locale por defecto del sistema.
     * @return Saludo internacionalizado según el locale especificado.
     */
    @GetMapping("/saludo")
    public String obtenerSaludo(@RequestHeader(name = "Accept-Language", required = false) String locale) {
        return messageSource.getMessage("saludo", null, parseLocale(locale));
    }

    /**
     * Convierte una cadena de locale en un objeto Locale.
     * Si la cadena es vacía o nula, se utiliza el locale por defecto del sistema.
     *
     * @param acceptLanguage Cadena de locale proporcionada en el encabezado 'Accept-Language'.
     * @return Objeto Locale correspondiente a la cadena proporcionada.
     */
    private Locale parseLocale(String acceptLanguage) {
        if (acceptLanguage == null || acceptLanguage.isEmpty()) {
            return Locale.getDefault();
        }
        // Tomar solo la primera parte antes de la coma
        String primaryLocale = acceptLanguage.split(",")[0].trim();
        try {
            return Locale.forLanguageTag(primaryLocale);
        } catch (IllegalArgumentException e) {
            // Manejar el caso donde el tag de locale no es válido
            return Locale.getDefault();
        }
    }
}
