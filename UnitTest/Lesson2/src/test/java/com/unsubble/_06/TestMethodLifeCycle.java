package com.unsubble._06;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TestMethodLifeCycle {

    // @TestInstance(Lifecycle.PER_METHOD) // default lifecycle (yani her test için o class'tan yeni bir 
											// instance oluşur.)
    // @TestInstance(Lifecycle.PER_CLASS)
    // tüm projede default halini PER_CLASS yapmak istiyorsak resources altında junit-platform.properties 
							// isimli bir dosya açıp junit.jupiter.testinstance.lifecycle.default = per_class
							// yazmamız gerek.
	
	
}
