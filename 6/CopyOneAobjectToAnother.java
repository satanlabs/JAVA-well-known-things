
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.Collection;

public class MyBeansUtil<T> {
	public T copyNonNullProperties(T target, T source) {
        if (source == null || target == null || target.getClass() != source.getClass()) return null;

        final BeanWrapper src = new BeanWrapperImpl(source);
        final BeanWrapper trg = new BeanWrapperImpl(target);

        for (final Field property : target.getClass().getDeclaredFields()) {
            Object srcObject = src.getPropertyValue(property.getName());
            
            if(srcObject instanceof Number) {
            	Number srcNumber = (Number)srcObject;
            	Number trgNumber = (Number)trg.getPropertyValue(property.getName());
            	
            	if(srcNumber.doubleValue() != 0.0 && trgNumber.doubleValue() == 0.0) {
            		trg.setPropertyValue(
                            property.getName(),
                            srcObject);
            	}
            }
            else if (srcObject != null && !(srcObject instanceof Number) && !(srcObject instanceof Collection<?>)) {
                trg.setPropertyValue(
                        property.getName(),
                        srcObject);
            }
            
        }
        return target;
    }
}
