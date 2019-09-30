package cn.chiucheung.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationLimit {
	String mid();
	String pid();
}
