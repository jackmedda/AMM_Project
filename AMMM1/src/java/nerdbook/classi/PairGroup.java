/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.classi;

/**
 *
 * @author Giacomo
 */
public class PairGroup {
    private String name;
    private String imagePath;
    
    public PairGroup (String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getImagePath() {
        return this.imagePath;
    }
}
