package com.example.j922springproject.client;

import com.example.j922springproject.model.exception.ClientException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class TexnoeraClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error("ActionLog.client.texnoera-client-failed");
        throw new ClientException("TEXNOERA_CLIENT_FAILED", 503);
    }
}
/*
Yeni bir microservice(proyekt) yaradırsız. ms-mail-sender
Bu ms-də bir api-ınız olacaq. Hansı ki o api-a body olaraq to, subject və message atacaqsız
Və bu ms sizin üçün maili göndərəcək və öz daxilində göndərdiyi mail məlumatlarını save edəcək

Hazırda scheduler olan servisinizdən bu yeni yaratdığınız ms-i FeignClient vasitəsi ilə çağıracaqsız

 */