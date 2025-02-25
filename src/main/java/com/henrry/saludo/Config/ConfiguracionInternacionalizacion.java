package com.henrry.saludo.Config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ConfiguracionInternacionalizacion {

    /**
     * Define un bean de MessageSource que carga mensajes desde archivos de propiedades.
     *
     * @return Un objeto MessageSource configurado para leer mensajes desde archivos de propiedades.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // Establece el nombre base de los archivos de propiedades.
        // Por ejemplo, "messages" para "messages.properties", "messages_en.properties", etc.
        messageSource.setBasename("messages");
        // Establece la codificación por defecto para los mensajes.
        // UTF-8 es recomendado para soportar caracteres especiales en diferentes idiomas.
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
