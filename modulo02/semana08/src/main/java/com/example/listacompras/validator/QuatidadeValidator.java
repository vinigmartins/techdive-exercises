package com.example.listacompras.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("QuantidadeValidator")
public class QuatidadeValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        if (value == null || (float) value < 0) {
            FacesMessage message = new FacesMessage("Valor informado invalido");
            throw new ValidatorException(message);
        }
    }
}
