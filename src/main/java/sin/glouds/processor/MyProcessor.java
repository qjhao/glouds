package sin.glouds.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Completion;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;


public class MyProcessor extends AbstractProcessor {

	private Messager messager;
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//		for(Element annotatedElement : roundEnv.getElementsAnnotatedWith(Factory.class)) {
//			if(annotatedElement.getKind() != ElementKind.CLASS) {
//				Error(annotatedElement, "only classes can be annotated with @%s", Factory.class.getSimpleName());
//				return true;
//			}
//		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private void Error(Element e, String msg, Object... args) {
		messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), e);
	}

	@Override
	public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation,
			ExecutableElement member, String userText) {
		// TODO Auto-generated method stub
		return super.getCompletions(element, annotation, member, userText);
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		// TODO Auto-generated method stub
		return super.getSupportedAnnotationTypes();
	}

	@Override
	public Set<String> getSupportedOptions() {
		// TODO Auto-generated method stub
		return super.getSupportedOptions();
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		// TODO Auto-generated method stub
		return super.getSupportedSourceVersion();
	}

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		// TODO Auto-generated method stub
		super.init(processingEnv);
	}

	@Override
	protected synchronized boolean isInitialized() {
		// TODO Auto-generated method stub
		return super.isInitialized();
	}

}
