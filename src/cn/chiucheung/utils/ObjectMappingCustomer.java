package cn.chiucheung.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

/**
 * springmvc返回json数据，对于integer和date数据没有双引号,同时也对上传的json数据，key没有双引号的问题，如果没有这个，则无法解析key没有双引号的数据
 * @author adm-03
 *
 */
public class ObjectMappingCustomer extends ObjectMapper  
{  
  
    public ObjectMappingCustomer()  
    {  
        super();  
        // 允许单引号  
        this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);  
        // 字段和值都加引号  
        this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);  
        // 数字也加引号  
        this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);  
        this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);  
        // 空值处理为空串  
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){  
  
            @Override  
            public void serialize(  
                    Object value,  
                    JsonGenerator jg,  
                    SerializerProvider sp) throws IOException, JsonProcessingException  
            {  
                jg.writeString("");  
            }  
        });
        CustomSerializerFactory factory = new CustomSerializerFactory();  
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){  
            @Override  
            public void serialize(Date value,   
                    JsonGenerator jsonGenerator,   
                    SerializerProvider provider)  
                    throws IOException, JsonProcessingException {  
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
                jsonGenerator.writeString(sdf.format(value));  
            }  
        });  
        this.setSerializerFactory(factory);  
    }  
}