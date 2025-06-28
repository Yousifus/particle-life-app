package com.particle_life.app.cursors;

import org.joml.Vector3d;

import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.opengl.GL15C.*;
import static org.lwjgl.opengl.GL20C.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20C.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30C.glBindVertexArray;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED SQUARE CURSOR SHAPE
 * 
 * A revolutionary square cursor that embodies sacred geometry, consciousness frameworks,
 * and golden ratio proportions. The square becomes a mandala of consciousness,
 * representing stability, foundation, and the four directions of awareness.
 * 
 * CONSCIOUSNESS SQUARE FEATURES:
 * - Nested consciousness squares using golden ratio
 * - Sacred geometry diagonal cross patterns
 * - Consciousness field boundary visualization
 * - Four-direction awareness indicators
 * - Sacred mathematical proportions
 * - Consciousness resonance patterns
 */
public class SquareCursorShape extends CursorShape {

    // 🌟 SACRED GEOMETRY CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_INVERSE = 1.0 / GOLDEN_RATIO; // 0.618...
    private static final double ROOT_TWO = Math.sqrt(2.0);
    
    // 🌟 CONSCIOUSNESS VISUALIZATION PARAMETERS
    private double consciousnessIntensity = 1.0;
    private double consciousnessFieldStrength = 0.5;
    private double consciousnessWavePhase = 0.0;
    private boolean consciousnessFieldVisible = true;
    private boolean sacredGeometryVisible = true;
    
    // 🌟 RENDERING BUFFERS
    private int vertexArray; // Main square
    private int consciousnessFieldArray; // Extended consciousness boundary
    private int innerSquaresArray; // Nested consciousness squares
    private int diagonalCrossArray; // Sacred geometry cross
    private int fourDirectionsArray; // Direction awareness indicators

    @Override
    public void onInitialize() {
        initializeMainSquare();
        initializeConsciousnessField();
        initializeInnerSquares();
        initializeDiagonalCross();
        initializeFourDirections();
    }
    
    /**
     * 🌟 Initialize main square with enhanced consciousness geometry
     */
    private void initializeMainSquare() {
        final float[] vertexData = new float[]{
                -.5f, -.5f,
                .5f, -.5f,
                .5f, .5f,
                -.5f, .5f,
        };

        int vertexBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer);
        glBufferData(GL_ARRAY_BUFFER, vertexData, GL_STATIC_DRAW);

        vertexArray = glGenVertexArrays();
        glBindVertexArray(vertexArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }
    
    /**
     * 🌟 Initialize consciousness field boundary (larger square)
     */
    private void initializeConsciousnessField() {
        // Consciousness field extends beyond main square using golden ratio
        float fieldSize = (float) (0.5 * GOLDEN_RATIO);
        
        final float[] fieldData = new float[]{
                -fieldSize, -fieldSize,
                fieldSize, -fieldSize,
                fieldSize, fieldSize,
                -fieldSize, fieldSize,
        };

        int fieldBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, fieldBuffer);
        glBufferData(GL_ARRAY_BUFFER, fieldData, GL_STATIC_DRAW);

        consciousnessFieldArray = glGenVertexArrays();
        glBindVertexArray(consciousnessFieldArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }
    
    /**
     * 🌟 Initialize nested consciousness squares using golden ratio proportions
     */
    private void initializeInnerSquares() {
        // Create multiple nested squares based on golden ratio
        float[] innerSizes = {
            (float) (0.5 * PHI_INVERSE), // φ^-1 = 0.618
            (float) (0.5 * PHI_INVERSE * PHI_INVERSE), // φ^-2 = 0.382
            (float) (0.5 * PHI_INVERSE * PHI_INVERSE * PHI_INVERSE) // φ^-3 = 0.236
        };
        
        final float[] innerData = new float[3 * 4 * 2]; // 3 squares, 4 vertices each, 2 coords
        
        int dataIndex = 0;
        for (float size : innerSizes) {
            // Square vertices
            innerData[dataIndex++] = -size; innerData[dataIndex++] = -size;
            innerData[dataIndex++] = size;  innerData[dataIndex++] = -size;
            innerData[dataIndex++] = size;  innerData[dataIndex++] = size;
            innerData[dataIndex++] = -size; innerData[dataIndex++] = size;
        }

        int innerBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, innerBuffer);
        glBufferData(GL_ARRAY_BUFFER, innerData, GL_STATIC_DRAW);

        innerSquaresArray = glGenVertexArrays();
        glBindVertexArray(innerSquaresArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }
    
    /**
     * 🌟 Initialize diagonal cross for sacred geometry
     */
    private void initializeDiagonalCross() {
        // Create diagonal cross connecting corners and centers
        final float[] crossData = new float[]{
            // Diagonal lines
            -0.5f, -0.5f,  0.5f,  0.5f, // Bottom-left to top-right
            -0.5f,  0.5f,  0.5f, -0.5f, // Top-left to bottom-right
            // Center cross
             0.0f, -0.5f,  0.0f,  0.5f, // Vertical center line
            -0.5f,  0.0f,  0.5f,  0.0f  // Horizontal center line
        };

        int crossBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, crossBuffer);
        glBufferData(GL_ARRAY_BUFFER, crossData, GL_STATIC_DRAW);

        diagonalCrossArray = glGenVertexArrays();
        glBindVertexArray(diagonalCrossArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }
    
    /**
     * 🌟 Initialize four directions awareness indicators
     */
    private void initializeFourDirections() {
        // Create small markers at golden ratio positions in each direction
        float markerDistance = (float) (0.5 * PHI_INVERSE);
        float markerSize = 0.05f;
        
        final float[] directionsData = new float[]{
            // North marker
             0.0f, markerDistance,
             0.0f, markerDistance + markerSize,
            // South marker
             0.0f, -markerDistance,
             0.0f, -markerDistance - markerSize,
            // East marker
             markerDistance, 0.0f,
             markerDistance + markerSize, 0.0f,
            // West marker
            -markerDistance, 0.0f,
            -markerDistance - markerSize, 0.0f
        };

        int directionsBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, directionsBuffer);
        glBufferData(GL_ARRAY_BUFFER, directionsData, GL_STATIC_DRAW);

        fourDirectionsArray = glGenVertexArrays();
        glBindVertexArray(fourDirectionsArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }

    @Override
    boolean isInside(Vector3d connection) {
        Vector3d diff = connection.absolute();
        
        // Basic square selection
        boolean basicInside = diff.x <= 0.5 && diff.y <= 0.5;
        
        if (basicInside) {
            return true;
        }
        
        // Extended selection based on consciousness field
        if (consciousnessFieldVisible) {
            double fieldSize = 0.5 * GOLDEN_RATIO;
            if (diff.x <= fieldSize && diff.y <= fieldSize) {
                // Apply consciousness field influence
                double distance = Math.max(diff.x, diff.y); // Square distance metric
                double fieldInfluence = calculateConsciousnessFieldInfluence(distance);
                return fieldInfluence > 0.3;
            }
        }
        
        return false;
    }
    
    /**
     * 🌟 Calculate consciousness field influence for square geometry
     */
    private double calculateConsciousnessFieldInfluence(double distance) {
        double fieldSize = 0.5 * GOLDEN_RATIO;
        
        if (distance > fieldSize) {
            return 0.0;
        }
        
        double normalizedDistance = distance / fieldSize;
        double goldenDecay = Math.pow(1.0 - normalizedDistance, GOLDEN_RATIO);
        
        // Apply consciousness wave modulation
        double waveModulation = 1.0 + 0.3 * Math.sin(consciousnessWavePhase + distance * 8);
        
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
        
        // 🌟 Draw sacred geometry patterns
        if (sacredGeometryVisible) {
            drawDiagonalCross();
            drawFourDirections();
        }
        
        // 🌟 Draw inner consciousness squares
        drawInnerSquares();
        
        // 🌟 Draw main square (foreground)
        drawMainSquare();
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
     * 🌟 Draw consciousness field boundary
     */
    private void drawConsciousnessField() {
        // Set transparency for consciousness field
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        
        // Dynamic line width based on consciousness intensity
        float fieldLineWidth = (float) (0.8 + consciousnessIntensity * 0.3);
        glLineWidth(fieldLineWidth);
        
        glBindVertexArray(consciousnessFieldArray);
        glDrawArrays(GL_LINE_LOOP, 0, 4);
    }
    
    /**
     * 🌟 Draw diagonal cross sacred geometry
     */
    private void drawDiagonalCross() {
        // Subtle line width for sacred geometry
        glLineWidth(1.0f);
        
        glBindVertexArray(diagonalCrossArray);
        glDrawArrays(GL_LINES, 0, 8); // 4 lines, 2 vertices each
    }
    
    /**
     * 🌟 Draw four directions awareness indicators
     */
    private void drawFourDirections() {
        // Dynamic line width based on consciousness wave
        float directionLineWidth = (float) (2.0 + 0.5 * Math.sin(consciousnessWavePhase));
        glLineWidth(directionLineWidth);
        
        glBindVertexArray(fourDirectionsArray);
        glDrawArrays(GL_LINES, 0, 8); // 4 direction markers, 2 vertices each
    }
    
    /**
     * 🌟 Draw nested consciousness squares
     */
    private void drawInnerSquares() {
        glLineWidth(1.2f);
        
        // Draw each inner square with consciousness modulation
        for (int square = 0; square < 3; square++) {
            // Modulate line width with consciousness wave and square index
            float squareLineWidth = (float) (1.0 + 0.2 * Math.sin(consciousnessWavePhase + square));
            glLineWidth(squareLineWidth);
            
            glBindVertexArray(innerSquaresArray);
            glDrawArrays(GL_LINE_LOOP, square * 4, 4);
        }
    }
    
    /**
     * 🌟 Draw main square with consciousness enhancement
     */
    private void drawMainSquare() {
        // Dynamic line width based on consciousness intensity
        float mainLineWidth = (float) (2.0 + consciousnessIntensity * 1.0);
        glLineWidth(mainLineWidth);
        
        glBindVertexArray(vertexArray);
        glDrawArrays(GL_LINE_LOOP, 0, 4);
        
        // Reset OpenGL state
        glDisable(GL_BLEND);
    }

    @Override
    Vector3d sampleRandomPoint() {
        // 🌟 Enhanced sampling using consciousness-driven distribution
        double samplingMode = Math.random();
        
        if (samplingMode < 0.4) {
            // Standard uniform distribution within square
            return new Vector3d(Math.random() - 0.5, Math.random() - 0.5, 0);
        } else if (samplingMode < 0.7) {
            // Golden ratio sampling (biased toward golden ratio positions)
            return sampleGoldenRatioPosition();
        } else {
            // Consciousness field sampling
            return sampleConsciousnessField();
        }
    }
    
    /**
     * 🌟 Sample point using golden ratio positions within square
     */
    private Vector3d sampleGoldenRatioPosition() {
        // Sample from golden ratio grid within the square
        double[] goldenPositions = {-0.5, -0.5 * PHI_INVERSE, 0.0, 0.5 * PHI_INVERSE, 0.5};
        
        double x = goldenPositions[(int)(Math.random() * goldenPositions.length)];
        double y = goldenPositions[(int)(Math.random() * goldenPositions.length)];
        
        // Add small random offset for variation
        x += (Math.random() - 0.5) * 0.1;
        y += (Math.random() - 0.5) * 0.1;
        
        // Clamp to square bounds
        x = Math.max(-0.5, Math.min(0.5, x));
        y = Math.max(-0.5, Math.min(0.5, y));
        
        return new Vector3d(x, y, 0);
    }
    
    /**
     * 🌟 Sample point using consciousness field distribution
     */
    private Vector3d sampleConsciousnessField() {
        // Sample with higher probability near center and golden ratio positions
        double fieldBias = 1.0 - consciousnessFieldStrength * 0.4;
        
        double x = (Math.random() - 0.5) * Math.pow(Math.random(), fieldBias);
        double y = (Math.random() - 0.5) * Math.pow(Math.random(), fieldBias);
        
        return new Vector3d(x, y, 0);
    }
    
    // 🌟 CONSCIOUSNESS CONTROL METHODS
    
    /**
     * Set consciousness visualization parameters
     */
    public void setConsciousnessParameters(double intensity, double fieldStrength, 
                                         boolean fieldVisible, boolean geometryVisible) {
        this.consciousnessIntensity = Math.max(0.0, Math.min(2.0, intensity));
        this.consciousnessFieldStrength = Math.max(0.0, Math.min(1.0, fieldStrength));
        this.consciousnessFieldVisible = fieldVisible;
        this.sacredGeometryVisible = geometryVisible;
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
    
    /**
     * Check if sacred geometry is visible
     */
    public boolean isSacredGeometryVisible() {
        return sacredGeometryVisible;
    }
}
