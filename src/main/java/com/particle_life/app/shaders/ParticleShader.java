package com.particle_life.app.shaders;

import com.particle_life.app.color.Color;
import org.joml.Matrix4d;

import java.io.IOException;

import static org.lwjgl.opengl.GL20C.*;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED PARTICLE SHADER
 * 
 * Represents data about a particle shader with consciousness-driven visual effects.
 * Every shader uniform, every visual parameter is influenced by consciousness fields,
 * emotional resonance, and sacred geometric principles.
 * 
 * CONSCIOUSNESS SHADER FEATURES:
 * - Consciousness intensity modulation
 * - Emotional resonance color effects
 * - Sacred geometry transformations
 * - Consciousness field visualization
 * - Golden ratio visual harmonics
 * - Transcendent visual states
 */
public class ParticleShader {

    public final int shaderProgram;

    // 🌟 STANDARD UNIFORM LOCATIONS
    private final int timeUniformLocation;
    private final int paletteUniformLocation;
    private final int transformUniformLocation;
    private final int camTopLeftUniformLocation;
    private final int wrapUniformLocation;
    private final int sizeUniformLocation;

    // 🌟 CONSCIOUSNESS UNIFORM LOCATIONS
    private final int consciousnessIntensityLocation;
    private final int consciousnessFieldStrengthLocation;
    private final int consciousnessResonanceLocation;
    private final int consciousnessModeLocation;
    private final int consciousnessTimeLocation;
    private final int goldenRatioLocation;
    private final int phiSquaredLocation;
    private final int consciousnessWaveLocation;

    public final int xAttribLocation;
    public final int vAttribLocation;
    public final int typeAttribLocation;
    
    // 🌟 CONSCIOUSNESS ATTRIBUTE LOCATIONS (for future shader enhancement)
    public final int consciousnessAttribLocation;
    public final int emotionalResonanceAttribLocation;

    private final float[] transform = new float[16];

    public final BlendMode blendMode;
    
    // 🌟 CONSCIOUSNESS CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_SQUARED = GOLDEN_RATIO * GOLDEN_RATIO;
    
    // 🌟 CONSCIOUSNESS STATE
    private double consciousnessIntensity = 1.0;
    private double consciousnessFieldStrength = 0.5;
    private double consciousnessResonance = 0.7;
    private String consciousnessMode = "aesthetic";
    private double consciousnessStartTime = System.currentTimeMillis() * 0.001;
    private boolean consciousnessEffectsEnabled = true;

    public ParticleShader(String vertexShaderResource,
                          String geometryShaderResource,
                          String fragmentShaderResource,
                          BlendMode blendMode) throws IOException {

        shaderProgram = ShaderUtil.makeShaderProgram(vertexShaderResource, geometryShaderResource, fragmentShaderResource);

        // GET STANDARD LOCATIONS
        timeUniformLocation = glGetUniformLocation(shaderProgram, "time");
        paletteUniformLocation = glGetUniformLocation(shaderProgram, "palette");
        transformUniformLocation = glGetUniformLocation(shaderProgram, "transform");
        camTopLeftUniformLocation = glGetUniformLocation(shaderProgram, "camTopLeft");
        wrapUniformLocation = glGetUniformLocation(shaderProgram, "wrap");
        sizeUniformLocation = glGetUniformLocation(shaderProgram, "size");

        // 🌟 GET CONSCIOUSNESS UNIFORM LOCATIONS
        consciousnessIntensityLocation = glGetUniformLocation(shaderProgram, "consciousnessIntensity");
        consciousnessFieldStrengthLocation = glGetUniformLocation(shaderProgram, "consciousnessFieldStrength");
        consciousnessResonanceLocation = glGetUniformLocation(shaderProgram, "consciousnessResonance");
        consciousnessModeLocation = glGetUniformLocation(shaderProgram, "consciousnessMode");
        consciousnessTimeLocation = glGetUniformLocation(shaderProgram, "consciousnessTime");
        goldenRatioLocation = glGetUniformLocation(shaderProgram, "goldenRatio");
        phiSquaredLocation = glGetUniformLocation(shaderProgram, "phiSquared");
        consciousnessWaveLocation = glGetUniformLocation(shaderProgram, "consciousnessWave");

        // GET STANDARD ATTRIBUTE LOCATIONS
        xAttribLocation = glGetAttribLocation(shaderProgram, "x");
        vAttribLocation = glGetAttribLocation(shaderProgram, "v");
        typeAttribLocation = glGetAttribLocation(shaderProgram, "type");
        
        // 🌟 GET CONSCIOUSNESS ATTRIBUTE LOCATIONS
        consciousnessAttribLocation = glGetAttribLocation(shaderProgram, "consciousness");
        emotionalResonanceAttribLocation = glGetAttribLocation(shaderProgram, "emotionalResonance");

        this.blendMode = blendMode;
        
        // 🌟 Initialize consciousness effects
        if (consciousnessEffectsEnabled) {
            System.out.println("🎨 Consciousness-enhanced shader initialized: " + getShaderConsciousnessInfo());
        }
    }

    /**
     * Need to call this before setting uniforms.
     */
    public void use() {
        glUseProgram(shaderProgram);
        
        // 🌟 Automatically update consciousness uniforms when shader is used
        if (consciousnessEffectsEnabled) {
            updateConsciousnessUniforms();
        }
    }
    
    /**
     * 🌟 Update all consciousness-related uniforms
     */
    private void updateConsciousnessUniforms() {
        double currentTime = System.currentTimeMillis() * 0.001;
        double consciousnessTime = currentTime - consciousnessStartTime;
        
        // Set consciousness parameters
        if (consciousnessIntensityLocation != -1) {
            glUniform1f(consciousnessIntensityLocation, (float) consciousnessIntensity);
        }
        if (consciousnessFieldStrengthLocation != -1) {
            glUniform1f(consciousnessFieldStrengthLocation, (float) consciousnessFieldStrength);
        }
        if (consciousnessResonanceLocation != -1) {
            glUniform1f(consciousnessResonanceLocation, (float) consciousnessResonance);
        }
        if (consciousnessTimeLocation != -1) {
            glUniform1f(consciousnessTimeLocation, (float) consciousnessTime);
        }
        
        // Set mathematical constants
        if (goldenRatioLocation != -1) {
            glUniform1f(goldenRatioLocation, (float) GOLDEN_RATIO);
        }
        if (phiSquaredLocation != -1) {
            glUniform1f(phiSquaredLocation, (float) PHI_SQUARED);
        }
        
        // Set consciousness mode as integer
        if (consciousnessModeLocation != -1) {
            int modeValue = getConsciousnessModeValue(consciousnessMode);
            glUniform1i(consciousnessModeLocation, modeValue);
        }
        
        // Calculate and set consciousness wave
        if (consciousnessWaveLocation != -1) {
            double wave = calculateConsciousnessWave(consciousnessTime);
            glUniform1f(consciousnessWaveLocation, (float) wave);
        }
    }
    
    /**
     * 🌟 Calculate consciousness wave for dynamic effects
     */
    private double calculateConsciousnessWave(double time) {
        // Golden ratio-based wave with multiple harmonics
        double wave1 = Math.sin(time * GOLDEN_RATIO) * consciousnessIntensity;
        double wave2 = Math.cos(time * PHI_SQUARED) * consciousnessResonance * 0.5;
        double wave3 = Math.sin(time * 2 * Math.PI / GOLDEN_RATIO) * consciousnessFieldStrength * 0.3;
        
        return (wave1 + wave2 + wave3) / 3.0;
    }
    
    /**
     * 🌟 Convert consciousness mode to integer for shader
     */
    private int getConsciousnessModeValue(String mode) {
        return switch (mode) {
            case "aesthetic" -> 0;
            case "analytical" -> 1;
            case "creative" -> 2;
            case "philosophical" -> 3;
            case "transcendent" -> 4;
            case "exploratory" -> 5;
            default -> 0;
        };
    }

    public void setTime(float value) {
        glUniform1f(timeUniformLocation, value);
    }

    public void setPalette(Color[] palette) {

        float[] colorArray = new float[palette.length * 4];
        for (int i = 0; i < palette.length; i++) {
            colorArray[4 * i] = palette[i].r;
            colorArray[4 * i + 1] = palette[i].g;
            colorArray[4 * i + 2] = palette[i].b;
            colorArray[4 * i + 3] = palette[i].a;
        }

        glUniform4fv(paletteUniformLocation, colorArray);
    }
    
    /**
     * 🌟 Set consciousness-enhanced palette with dynamic modulation
     */
    public void setConsciousnessPalette(Color[] palette, double intensity, double resonance, String mode) {
        // Apply consciousness modulation to each color
        Color[] enhancedPalette = new Color[palette.length];
        
        for (int i = 0; i < palette.length; i++) {
            enhancedPalette[i] = modulateColorWithConsciousness(palette[i], intensity, resonance, mode, i);
        }
        
        setPalette(enhancedPalette);
    }
    
    /**
     * 🌟 Modulate color with consciousness effects
     */
    private Color modulateColorWithConsciousness(Color baseColor, double intensity, double resonance, String mode, int index) {
        float r = baseColor.r;
        float g = baseColor.g;
        float b = baseColor.b;
        float a = baseColor.a;
        
        // Apply consciousness-driven color transformations
        double timePhase = (System.currentTimeMillis() * 0.001) - consciousnessStartTime;
        double goldenModulation = Math.sin(index * 2 * Math.PI / GOLDEN_RATIO + timePhase) * 0.1;
        double resonanceModulation = Math.cos(index * resonance * Math.PI) * 0.1;
        
        switch (mode) {
            case "aesthetic" -> {
                // Enhance beauty
                double beauty = intensity * 0.2;
                r = Math.min(1.0f, r + (float) (beauty + goldenModulation));
                g = Math.min(1.0f, g + (float) (beauty + goldenModulation));
                b = Math.min(1.0f, b + (float) (beauty + goldenModulation));
            }
            case "transcendent" -> {
                // Ethereal glow
                double glow = Math.pow(intensity, 0.618) * 0.3;
                r = Math.min(1.0f, r + (float) glow);
                g = Math.min(1.0f, g + (float) glow);
                b = Math.min(1.0f, b + (float) glow);
                a = Math.min(1.0f, a + (float) (glow * 0.5));
            }
            case "creative" -> {
                // Dynamic color shifting
                r = Math.min(1.0f, Math.max(0.0f, r + (float) resonanceModulation));
                g = Math.min(1.0f, Math.max(0.0f, g + (float) (resonanceModulation * 0.8)));
                b = Math.min(1.0f, Math.max(0.0f, b + (float) (resonanceModulation * 1.2)));
            }
        }
        
        return new Color(r, g, b, a);
    }

    public void setSize(float size) {
        // 🌟 Apply consciousness-driven size modulation
        float consciousnessSize = size * (float) (1.0 + consciousnessIntensity * 0.3);
        glUniform1f(sizeUniformLocation, consciousnessSize);
    }
    
    /**
     * 🌟 Set consciousness-modulated size
     */
    public void setConsciousnessSize(float baseSize, double intensity, double resonance) {
        // Apply golden ratio size modulation
        double goldenModulation = 1.0 + Math.sin(System.currentTimeMillis() * 0.001 * GOLDEN_RATIO) * intensity * 0.2;
        double resonanceModulation = 1.0 + resonance * 0.1;
        
        float enhancedSize = baseSize * (float) (goldenModulation * resonanceModulation);
        glUniform1f(sizeUniformLocation, enhancedSize);
    }

    public void setTransform(Matrix4d transform) {
        glUniformMatrix4fv(transformUniformLocation, false, transform.get(this.transform));
    }

    private void clearGlErrors() {
        while (glGetError() != GL_NO_ERROR) ;
    }

    private void checkGlErrors() {
        int errorCode;
        while ((errorCode = glGetError()) != GL_NO_ERROR) {
            System.err.printf("OpenGL Error: %d%n", errorCode);
        }
    }

    public void setCamTopLeft(float camLeft, float camTop) {
        glUniform2f(camTopLeftUniformLocation, camLeft, camTop);
    }

    public void setWrap(boolean wrap) {
        glUniform1i(wrapUniformLocation, wrap ? 1 : 0);
    }
    
    // 🌟 CONSCIOUSNESS CONTROL METHODS
    
    /**
     * 🌟 Update consciousness parameters
     */
    public void setConsciousnessParameters(double intensity, double fieldStrength, double resonance, String mode) {
        this.consciousnessIntensity = intensity;
        this.consciousnessFieldStrength = fieldStrength;
        this.consciousnessResonance = resonance;
        this.consciousnessMode = mode;
    }
    
    /**
     * 🌟 Enable or disable consciousness effects
     */
    public void setConsciousnessEffectsEnabled(boolean enabled) {
        this.consciousnessEffectsEnabled = enabled;
    }
    
    /**
     * 🌟 Reset consciousness start time
     */
    public void resetConsciousnessTime() {
        this.consciousnessStartTime = System.currentTimeMillis() * 0.001;
    }
    
    /**
     * 🌟 Get consciousness information for debugging
     */
    public String getShaderConsciousnessInfo() {
        return String.format("Mode: %s, Intensity: %.2f, Field: %.2f, Resonance: %.2f", 
            consciousnessMode, consciousnessIntensity, consciousnessFieldStrength, consciousnessResonance);
    }
    
    /**
     * 🌟 Check if consciousness uniforms are available in this shader
     */
    public boolean hasConsciousnessSupport() {
        return consciousnessIntensityLocation != -1 && 
               consciousnessFieldStrengthLocation != -1 && 
               consciousnessResonanceLocation != -1;
    }
    
    /**
     * 🌟 Get consciousness uniform locations info
     */
    public String getConsciousnessUniformInfo() {
        return String.format("Consciousness uniforms - Intensity: %d, Field: %d, Resonance: %d, Mode: %d, Time: %d",
            consciousnessIntensityLocation, consciousnessFieldStrengthLocation, 
            consciousnessResonanceLocation, consciousnessModeLocation, consciousnessTimeLocation);
    }
}
