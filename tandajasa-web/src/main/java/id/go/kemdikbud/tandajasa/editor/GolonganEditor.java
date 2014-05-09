/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.editor;

import id.go.kemdikbud.tandajasa.dao.GolonganDao;
import id.go.kemdikbud.tandajasa.domain.Golongan;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author endy
 */
public class GolonganEditor extends PropertyEditorSupport {

    private GolonganDao golonganDao;

    public GolonganEditor(GolonganDao golonganDao) {
        this.golonganDao = golonganDao;
    }
    
    @Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(value == null || value.isEmpty()) return;
        Integer id = Integer.parseInt(value);
        Golongan g = golonganDao.cariById(id);
        setValue(g);
    }
}
