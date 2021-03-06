/*
 * generated by Xtext 2.10.0
 */
package org.eclipse.gemoc.ui.contentassist

import org.eclipse.core.runtime.IConfigurationElement
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.gemoc.dsl.Entry
import org.eclipse.gemoc.dsl.Dsl
import org.eclipse.xtext.RuleCall
import java.util.ArrayList
import org.eclipse.gemoc.xdsmlframework.api.extensions.metaprog.LanguageComponentHelper

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
class DslProposalProvider extends AbstractDslProposalProvider {
	
	val approachHelper = new LanguageComponentHelper()
	
	val IConfigurationElement[] metaprogApproach = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.gemoc.gemoc_language_workbench.metaprog")
	
	override completeEntry_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor){
		super.completeEntry_Value(model, assignment, context, acceptor)
		
		if(model instanceof Entry){
			if("metaprog".equals(model.key)){
				for (IConfigurationElement approach : metaprogApproach){
					var name = approach.getAttribute("name")
					acceptor.accept(createCompletionProposal(name, context))
				}
			}
		}
	}
	
	override complete_SPACE(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor){
		super.complete_SPACE(model, ruleCall, context, acceptor)
		
		var String metaprog
		var ArrayList<IConfigurationElement> keys = new ArrayList<IConfigurationElement>()
		var ArrayList<String> dslKeys = new ArrayList<String>()
		
		if (model instanceof Dsl){
			for (Entry entry : model.getEntries()){
				dslKeys.add(entry.key)
				if("metaprog".equals(entry.key)){
					metaprog = entry.value
				}
			}
			if(!dslKeys.contains("name")){
				var displayString = "name - name of the DSL"
				acceptor.accept(createCompletionProposal("name", displayString, null, context))
			}
			if(!dslKeys.contains("metaprog")){
				var String displayString = "metaprog - metaprogramming approach used"
				acceptor.accept(createCompletionProposal("metaprog", displayString, null, context))
			}
			
			keys = approachHelper.getFullApproachKeys(metaprog)
			
			for(IConfigurationElement key : keys){
				var name = key.getAttribute('name')
				var optional = key.getAttribute('optional')
				var String displayString = name + " - "
				if("true".equals(optional)){
					displayString = displayString + "(optional) "
				}
				displayString = displayString + key.getAttribute("description")
				if(!dslKeys.contains(name)){
					acceptor.accept(createCompletionProposal(name, displayString, null,context))
				}
			}
		}
	}
}
