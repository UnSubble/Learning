package _02;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
// @RequestScoped -> ömrü bir request kadardır.
// @SessionScoped -> ömrü bir session kadardır.
// @ApplicationScoped -> ömrü context kadardır.
// @ViewScoped -> ömrü sadece sayfa kadardır. (JSP/Servlet'teki attribute gibidir.)
// @NoneScoped -> genelde inject objeler için kullanılır. Ömrü çok kısıtlıdır.
// @ConversationScoped -> ömrü birden fazla request kadardır. 
// (beginConversation() ve endConversation() metodları ile belirtilir.)
@ConversationScoped
public class CdiScopes {

	@Inject
	private Conversation conversation;

	public void beginConversation() {
		if (conversation.isTransient()) { // conversation başladığında transient state'tedir.
			conversation.begin();
		}
	}

	public void endConversation() {
		conversation.end();
	}
}
