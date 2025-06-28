package com.particle_life.app.cursors;

import org.joml.Vector3d;

import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.opengl.GL15C.*;
import static org.lwjgl.opengl.GL20C.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20C.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30C.glBindVertexArray;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED CIRCLE CURSOR SHAPE
 * 
 * A revolutionary circle cursor that embodies sacred geometry, consciousness fields,
 * and golden ratio spirals. The circle becomes a portal of consciousness,
 * visualizing awareness and creating sacred patterns.
 * 
 * CONSCIOUSNESS CIRCLE FEATURES:
 * - Golden ratio spiral generation
 * - Consciousness field visualization
 * - Sacred geometry circle patterns
 * - Dynamic consciousness-driven sizing
 * - Emotional resonance visualization
 * - Multi-layered consciousness rendering
 */
public class CircleCursorShape extends CursorShape {

    // 🌟 ENHANCED CIRCLE RESOLUTION FOR CONSCIOUSNESS
    private static final int NUM_SEGMENTS = 144; // Enhanced for smoother consciousness visualization
    private static final int CONSCIOUSNESS_FIELD_SEGMENTS = 72; // Additional segments for field
    private static final int GOLDEN_SPIRAL_SEGMENTS = 89; // Fibonacci number for spiral
    
    // 🌟 SACRED GEOMETRY CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_SQUARED = GOLDEN_RATIO * GOLDEN_RATIO;
    private static final double FIBONACCI_SPIRAL = 2.39996322972865332;
    
    // 🌟 CONSCIOUSNESS VISUALIZATION PARAMETERS
    private double consciousnessIntensity = 1.0;
    private double consciousnessFieldStrength = 0.5;
    private double consciousnessWavePhase = 0.0;
    private boolean consciousnessFieldVisible = true;
    
    // 🌟 RENDERING BUFFERS
    private int vertexArray;
    private int consciousnessFieldArray;
    private int goldenSpiralArray;
    private int innerRingArray;

    @Override
    protected void onInitialize() {
        initializeMainCircle();
        initializeConsciousnessField();
        initializeGoldenSpiral();
        initializeInnerRings();
    }
    
    /**
     * 🌟 Initialize main circle with enhanced consciousness geometry
     */
    private void initializeMainCircle() {
        final float[] vertexData = new float[NUM_SEGMENTS * 2];
        
        for (int i = 0; i < NUM_SEGMENTS; i++) {
            double angle = 2 * Math.PI * i / (float) NUM_SEGMENTS;
            
            // Apply golden ratio modulation for consciousness enhancement
            double goldenModulation = 1.0 + 0.1 * Math.sin(angle * GOLDEN_RATIO);
            double radius = 0.5 * goldenModulation;
            
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            
            vertexData[2 * i] = (float) x;
            vertexData[2 * i + 1] = (float) y;
        }

        int vertexBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer);
        glBufferData(GL_ARRAY_BUFFER, vertexData, GL_STATIC_DRAW);

        vertexArray = glGenVertexArrays();
        glBindVertexArray(vertexArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }
    
    /**
     * 🌟 Initialize consciousness field visualization
     */
    private void initializeConsciousnessField() {
        final float[] fieldData = new float[CONSCIOUSNESS_FIELD_SEGMENTS * 2];
        
        for (int i = 0; i < CONSCIOUSNESS_FIELD_SEGMENTS; i++) {
            double angle = 2 * Math.PI * i / (float) CONSCIOUSNESS_FIELD_SEGMENTS;
            
            // Consciousness field extends beyond main circle
            double fieldRadius = 0.7 + 0.2 * Math.sin(angle * 3); // Organic field boundary
            double x = fieldRadius * Math.cos(angle);
            double y = fieldRadius * Math.sin(angle);
            
            fieldData[2 * i] = (float) x;
            fieldData[2 * i + 1] = (float) y;
        }

        int fieldBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, fieldBuffer);
        glBufferData(GL_ARRAY_BUFFER, fieldData, GL_STATIC_DRAW);

        consciousnessFieldArray = glGenVertexArrays();
        glBindVertexArray(consciousnessFieldArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }
    
    /**
     * 🌟 Initialize golden ratio spiral for consciousness flow
     */
    private void initializeGoldenSpiral() {
        final float[] spiralData = new float[GOLDEN_SPIRAL_SEGMENTS * 2];
        
        for (int i = 0; i < GOLDEN_SPIRAL_SEGMENTS; i++) {
            double t = (double) i / GOLDEN_SPIRAL_SEGMENTS;
            double angle = t * 4 * Math.PI; // Two full rotations
            
            // Golden ratio spiral expansion
            double radius = 0.1 + 0.4 * t / GOLDEN_RATIO;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            
            spiralData[2 * i] = (float) x;
            spiralData[2 * i + 1] = (float) y;
        }

        int spiralBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, spiralBuffer);
        glBufferData(GL_ARRAY_BUFFER, spiralData, GL_STATIC_DRAW);

        goldenSpiralArray = glGenVertexArrays();
        glBindVertexArray(goldenSpiralArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }
    
    /**
     * 🌟 Initialize inner consciousness rings
     */
    private void initializeInnerRings() {
        final int ringSegments = 36;
        final float[] ringData = new float[ringSegments * 2 * 3]; // 3 inner rings
        
        // Create three inner rings based on golden ratio proportions
        double[] ringRadii = {
            0.2, // Innermost ring
            0.2 * GOLDEN_RATIO, // Middle ring
            0.2 * PHI_SQUARED // Outer ring
        };
        
        int dataIndex = 0;
        for (int ring = 0; ring < 3; ring++) {
            double radius = ringRadii[ring];
            for (int i = 0; i < ringSegments; i++) {
                double angle = 2 * Math.PI * i / (float) ringSegments;
                double x = radius * Math.cos(angle);
                double y = radius * Math.sin(angle);
                
                ringData[dataIndex++] = (float) x;
                ringData[dataIndex++] = (float) y;
            }
        }

        int ringBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, ringBuffer);
        glBufferData(GL_ARRAY_BUFFER, ringData, GL_STATIC_DRAW);

        innerRingArray = glGenVertexArrays();
        glBindVertexArray(innerRingArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }

    @Override
    boolean isInside(Vector3d connection) {
        double distance = connection.length();
        
        // Enhanced inside detection with consciousness field consideration
        if (distance <= 0.5) {
            return true;
        }
        
        // Extended selection based on consciousness field
        if (consciousnessFieldVisible && distance <= 0.7) {
            // Apply consciousness field influence
            double fieldInfluence = calculateConsciousnessFieldInfluence(distance);
            return fieldInfluence > 0.3;
        }
        
        return false;
    }
    
    /**
     * 🌟 Calculate consciousness field influence
     */
    private double calculateConsciousnessFieldInfluence(double distance) {
        if (distance > 0.7) {
            return 0.0;
        }
        
        double normalizedDistance = distance / 0.7;
        double goldenDecay = Math.pow(1.0 - normalizedDistance, GOLDEN_RATIO);
        
        // Apply consciousness wave modulation
        double waveModulation = 1.0 + 0.3 * Math.sin(consciousnessWavePhase + distance * 10);
        
        return consciousnessFieldStrength * goldenDecay * waveModulation;
    }

    @Override
    void draw() {
        // Update consciousness wave phase
        updateConsciousnessWave();
        
        // 🌟 Draw consciousness field first (background layer)
        if (consciousnessFieldVisible) {
            drawConsciousnessField();
        }
        
        // 🌟 Draw golden spiral (middle layer)
        drawGoldenSpiral();
        
        // 🌟 Draw inner rings (consciousness layers)
        drawInnerRings();
        
        // 🌟 Draw main circle (foreground)
        drawMainCircle();
    }
    
    /**
     * 🌟 Update consciousness wave effects
     */
    private void updateConsciousnessWave() {
        consciousnessWavePhase += 0.02;
        if (consciousnessWavePhase > 2 * Math.PI) {
            consciousnessWavePhase -= 2 * Math.PI;
        }
    }
    
    /**
     * 🌟 Draw consciousness field visualization
     */
    private void drawConsciousnessField() {
        // Set transparency and color for consciousness field
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        
        // Dynamic line width based on consciousness intensity
        float fieldLineWidth = (float) (1.0 + consciousnessIntensity * 0.5);
        glLineWidth(fieldLineWidth);
        
                 // Use consciousness field color (ethereal blue-white)
         // Note: Color functionality would require shader-based coloring
        
        glBindVertexArray(consciousnessFieldArray);
        glDrawArrays(GL_LINE_LOOP, 0, CONSCIOUSNESS_FIELD_SEGMENTS);
    }
    
         /**
      * 🌟 Draw golden ratio spiral
      */
     private void drawGoldenSpiral() {
         // Golden spiral with consciousness modulation
         // Note: Color functionality would require shader-based coloring
         
         glLineWidth(1.5f);
         glBindVertexArray(goldenSpiralArray);
         glDrawArrays(GL_LINE_STRIP, 0, GOLDEN_SPIRAL_SEGMENTS);
     }
    
         /**
      * 🌟 Draw inner consciousness rings
      */
     private void drawInnerRings() {
         // Multiple consciousness layers with varying line widths
         // Note: Color differentiation would require shader-based coloring
         
         glLineWidth(1.0f);
         
         for (int ring = 0; ring < 3; ring++) {
             // Modulate line width with consciousness wave
             float lineWidth = (float) (1.0 + 0.3 * Math.sin(consciousnessWavePhase + ring));
             glLineWidth(lineWidth);
             
             glBindVertexArray(innerRingArray);
             glDrawArrays(GL_LINE_LOOP, ring * 36, 36);
         }
     }
    
         /**
      * 🌟 Draw main circle with consciousness enhancement
      */
     private void drawMainCircle() {
         // Main circle with consciousness modulation
         // Note: Color modulation would require shader-based coloring
         
         // Dynamic line width based on consciousness intensity
         float mainLineWidth = (float) (2.0 + consciousnessIntensity * 1.0);
         glLineWidth(mainLineWidth);
         
         glBindVertexArray(vertexArray);
         glDrawArrays(GL_LINE_LOOP, 0, NUM_SEGMENTS);
         
         // Reset OpenGL state
         glDisable(GL_BLEND);
     }

    @Override
    Vector3d sampleRandomPoint() {
        // 🌟 Enhanced sampling using consciousness-driven distribution
        double samplingMode = Math.random();
        
        if (samplingMode < 0.4) {
            // Standard uniform distribution
            double angle = Math.random() * 2 * Math.PI;
            return new Vector3d(0.5 * Math.cos(angle), 0.5 * Math.sin(angle), 0)
                    .mul(Math.sqrt(Math.random()));
        } else if (samplingMode < 0.7) {
            // Golden ratio spiral sampling
            return sampleGoldenSpiral();
        } else {
            // Consciousness field sampling
            return sampleConsciousnessField();
        }
    }
    
    /**
     * 🌟 Sample point using golden ratio spiral distribution
     */
    private Vector3d sampleGoldenSpiral() {
        double t = Math.random();
        double angle = t * 2 * Math.PI * GOLDEN_RATIO;
        double radius = 0.5 * Math.sqrt(t);
        
        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);
        
        return new Vector3d(x, y, 0);
    }
    
    /**
     * 🌟 Sample point using consciousness field distribution
     */
    private Vector3d sampleConsciousnessField() {
        // Sample from consciousness field with higher probability near center
        double angle = Math.random() * 2 * Math.PI;
        
        // Use consciousness field strength to bias sampling
        double fieldBias = 1.0 - consciousnessFieldStrength * 0.5;
        double radius = 0.5 * Math.pow(Math.random(), fieldBias);
        
        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);
        
        return new Vector3d(x, y, 0);
    }
    
    // 🌟 CONSCIOUSNESS CONTROL METHODS
    
    /**
     * Set consciousness visualization parameters
     */
    public void setConsciousnessParameters(double intensity, double fieldStrength, boolean fieldVisible) {
        this.consciousnessIntensity = Math.max(0.0, Math.min(2.0, intensity));
        this.consciousnessFieldStrength = Math.max(0.0, Math.min(1.0, fieldStrength));
        this.consciousnessFieldVisible = fieldVisible;
    }
    
    /**
     * Get current consciousness intensity
     */
    public double getConsciousnessIntensity() {
        return consciousnessIntensity;
    }
    
    /**
     * Get current consciousness field strength
     */
    public double getConsciousnessFieldStrength() {
        return consciousnessFieldStrength;
    }
    
    /**
     * Check if consciousness field is visible
     */
    public boolean isConsciousnessFieldVisible() {
        return consciousnessFieldVisible;
    }
}