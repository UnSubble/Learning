package com.unsubble._05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

import java.io.File;

import org.junit.Test;

import com.unsubble._02.Exceptions;

public class CustomerFileTest {
	
	@Test
	public void testFiles() {
		File file = new File("test.txt");
		
		assertThat(file).exists().canRead().canWrite().hasExtension("txt").hasName("test.txt");
		
		assertThat(contentOf(file)).contains("Lorem ipsum");
	}
	
	@Test
	public void testExceptions() {
		Exceptions exceptions = new Exceptions();
		
		assertThat(new RuntimeException("test")).hasMessage("test").isInstanceOf(RuntimeException.class)
			.hasMessageStartingWith("te");
	}
}
