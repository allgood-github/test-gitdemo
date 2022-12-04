package com.wetrol.testdemo.config;

import com.wetrol.testdemo.domain.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class DefineUserMessageConverter implements HttpMessageConverter<User> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {

        return MediaType.parseMediaTypes("application/x-wetrol");
    }

    @Override
    public User read(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(User user, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义协议数据写出
        String[] likes = user.getLikes();
        String u = user.getUsername() + "***" + user.getGender() + "***" + user.getAge() + "***";
        for (String s : likes) {
            u = u + "***" + s;
        }

        //写出去
        OutputStream body = outputMessage.getBody();
        body.write(u.getBytes());

    }
}
