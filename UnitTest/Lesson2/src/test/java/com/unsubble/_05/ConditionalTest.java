package com.unsubble._05;

import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {

	// Bu koşul annotation'ları hem class için hem de metot için kullanılabilir.
	// @EnabledOnOs(OS.SOLARIS) ve @DisabledOnOs(OS.WINDOWS) işletim sistemine göre 
	// @EnabledOnJre(JRE.JAVA_8) ve @DisabledOnJre(JRE.JAVA_11) java sürümleri için
	// @DisabledIfSystemProperty(named = "ENV") @EnabledIfSystemProperty  sistem değişkenleri için
	// @DisabledIfEnvironmentVariable @EnabledIfEnvironmentVariable(named = "ENV") çevre değişkenleri içim
	// @EnabledIf @DisabledIf script bazlı (javascript, groovy) için // mesela @EnabledIf("2 * 3 == 6")
	
	
	
}
