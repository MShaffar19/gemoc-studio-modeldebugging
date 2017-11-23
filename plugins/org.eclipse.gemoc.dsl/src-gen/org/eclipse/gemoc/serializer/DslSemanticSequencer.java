/*
 * generated by Xtext 2.12.0
 */
package org.eclipse.gemoc.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gemoc.dsl.AbstractSyntax;
import org.eclipse.gemoc.dsl.CompositeValue;
import org.eclipse.gemoc.dsl.DisplayName;
import org.eclipse.gemoc.dsl.Dsl;
import org.eclipse.gemoc.dsl.DslPackage;
import org.eclipse.gemoc.dsl.Metaprog;
import org.eclipse.gemoc.dsl.Semantic;
import org.eclipse.gemoc.dsl.SimpleValue;
import org.eclipse.gemoc.services.DslGrammarAccess;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class DslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private DslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == DslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case DslPackage.ABSTRACT_SYNTAX:
				sequence_AbstractSyntax(context, (AbstractSyntax) semanticObject); 
				return; 
			case DslPackage.COMPOSITE_VALUE:
				sequence_CompositeValue(context, (CompositeValue) semanticObject); 
				return; 
			case DslPackage.DISPLAY_NAME:
				sequence_DisplayName(context, (DisplayName) semanticObject); 
				return; 
			case DslPackage.DSL:
				sequence_Dsl(context, (Dsl) semanticObject); 
				return; 
			case DslPackage.METAPROG:
				sequence_Metaprog(context, (Metaprog) semanticObject); 
				return; 
			case DslPackage.SEMANTIC:
				sequence_Semantic(context, (Semantic) semanticObject); 
				return; 
			case DslPackage.SIMPLE_VALUE:
				sequence_SimpleValue(context, (SimpleValue) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AbstractSyntax returns AbstractSyntax
	 *
	 * Constraint:
	 *     values+=Value*
	 */
	protected void sequence_AbstractSyntax(ISerializationContext context, AbstractSyntax semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Value returns CompositeValue
	 *     CompositeValue returns CompositeValue
	 *
	 * Constraint:
	 *     (name=ID values+=Value*)
	 */
	protected void sequence_CompositeValue(ISerializationContext context, CompositeValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DisplayName returns DisplayName
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_DisplayName(ISerializationContext context, DisplayName semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DslPackage.Literals.DISPLAY_NAME__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DISPLAY_NAME__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDisplayNameAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Dsl returns Dsl
	 *
	 * Constraint:
	 *     (
	 *         (name=QUALIFIED | name=ID) 
	 *         displayName=DisplayName? 
	 *         metaprog=Metaprog? 
	 *         abstractSyntax=AbstractSyntax? 
	 *         semantic=Semantic? 
	 *         values+=Value*
	 *     )
	 */
	protected void sequence_Dsl(ISerializationContext context, Dsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Metaprog returns Metaprog
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_Metaprog(ISerializationContext context, Metaprog semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DslPackage.Literals.METAPROG__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.METAPROG__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMetaprogAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Semantic returns Semantic
	 *
	 * Constraint:
	 *     values+=Value*
	 */
	protected void sequence_Semantic(ISerializationContext context, Semantic semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Value returns SimpleValue
	 *     SimpleValue returns SimpleValue
	 *
	 * Constraint:
	 *     (name=ID values+=STRING values+=STRING*)
	 */
	protected void sequence_SimpleValue(ISerializationContext context, SimpleValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
