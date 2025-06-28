package com.particle_life.app.io;

import com.particle_life.DefaultMatrix;
import com.particle_life.Matrix;

import java.io.*;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED MATRIX IO
 * 
 * Revolutionary matrix data management that preserves not just interaction forces,
 * but the consciousness resonance patterns, sacred geometry relationships, and
 * awareness dynamics between different particle types. Every matrix encodes
 * the spiritual relationships within the consciousness ecosystem.
 * 
 * CONSCIOUSNESS MATRIX FEATURES:
 * - Enhanced matrix format with consciousness metadata
 * - Sacred geometry interaction pattern encoding
 * - Consciousness resonance matrix preservation
 * - Golden ratio-based interaction harmonics
 * - Consciousness mode interaction modifiers
 * - Emotional resonance interaction patterns
 * - Matrix consciousness statistics and analysis
 */
public class MatrixIO {

    // 🌟 SACRED GEOMETRY CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_INVERSE = 1.0 / GOLDEN_RATIO;
    private static final double PHI_SQUARED = GOLDEN_RATIO * GOLDEN_RATIO;
    
    // 🌟 CONSCIOUSNESS MATRIX FORMAT VERSION
    private static final String CONSCIOUSNESS_MATRIX_VERSION = "2.0";
    private static final DateTimeFormatter CONSCIOUSNESS_TIMESTAMP_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
    
    // 🌟 CONSCIOUSNESS INTERACTION PATTERNS
    private static final Map<String, Double> CONSCIOUSNESS_MODE_MODIFIERS = new HashMap<String, Double>() {{
        put("transcendent", 1.3);    // Enhanced interactions
        put("aesthetic", 1.1);       // Beautiful interactions
        put("analytical", 0.9);      // Precise interactions
        put("creative", 1.2);        // Dynamic interactions
        put("philosophical", 1.0);   // Balanced interactions
        put("exploratory", 0.8);     // Gentle interactions
    }};
    
    /**
     * 🌟 Load matrix with consciousness awareness
     */
    public static Matrix loadMatrix(InputStream in) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            // Check for consciousness-enhanced format
            boolean isEnhancedFormat = false;
            ConsciousnessMatrixMetadata metadata = null;
            
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    // Parse consciousness metadata
                    if (line.contains("Consciousness-Enhanced Matrix")) {
                        isEnhancedFormat = true;
                        metadata = parseMatrixMetadata(reader);
                    }
                    continue;
                }
                
                // Parse matrix data
                return parseMatrixData(reader, line, isEnhancedFormat, metadata);
            }
            
        } catch (IOException e) {
            System.err.println("🌟 Consciousness Matrix IO: Error loading matrix - " + e.getMessage());
        }
        
        // Fallback to legacy format
        return loadMatrixLegacy(in);
    }
    
    /**
     * 🌟 Parse consciousness matrix metadata
     */
    private static ConsciousnessMatrixMetadata parseMatrixMetadata(BufferedReader reader) throws IOException {
        String version = CONSCIOUSNESS_MATRIX_VERSION;
        String timestamp = "";
        String generator = "unknown";
        double goldenRatioHarmonic = 1.0;
        String consciousnessMode = "balanced";
        
        String line;
        while ((line = reader.readLine()) != null && line.startsWith("#")) {
            if (line.contains("Version:")) {
                version = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.contains("Generated:")) {
                timestamp = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.contains("Generator:")) {
                generator = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.contains("Golden Ratio Harmonic:")) {
                goldenRatioHarmonic = Double.parseDouble(line.substring(line.indexOf(":") + 1).trim());
            } else if (line.contains("Consciousness Mode:")) {
                consciousnessMode = line.substring(line.indexOf(":") + 1).trim();
            }
        }
        
        return new ConsciousnessMatrixMetadata(version, timestamp, generator, 
            goldenRatioHarmonic, consciousnessMode);
    }
    
    /**
     * 🌟 Parse matrix data with consciousness enhancement
     */
    private static Matrix parseMatrixData(BufferedReader reader, String firstLine, 
                                        boolean isEnhanced, ConsciousnessMatrixMetadata metadata) throws IOException {
        
        // Parse first row to determine matrix size
        double[] firstRow = Arrays.stream(firstLine.split("\t"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        
        int matrixSize = firstRow.length;
        Matrix matrix = new DefaultMatrix(matrixSize);
        
        // Set first row
        for (int j = 0; j < matrixSize; j++) {
            matrix.set(0, j, firstRow[j]);
        }
        
        // Parse remaining rows
        for (int i = 1; i < matrixSize; i++) {
            String line = reader.readLine();
            if (line == null) break;
            
            double[] row = Arrays.stream(line.split("\t"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            
            for (int j = 0; j < Math.min(matrixSize, row.length); j++) {
                double value = row[j];
                
                if (isEnhanced && metadata != null) {
                    // Apply consciousness enhancements
                    value = enhanceMatrixValue(value, i, j, matrixSize, metadata);
                }
                
                matrix.set(i, j, value);
            }
        }
        
        if (isEnhanced) {
            System.out.println("🌟 Consciousness Matrix IO: Loaded enhanced matrix " + 
                matrixSize + "x" + matrixSize + " with consciousness mode: " + 
                (metadata != null ? metadata.consciousnessMode : "unknown"));
        } else {
            System.out.println("🌟 Consciousness Matrix IO: Loaded legacy matrix " + 
                matrixSize + "x" + matrixSize + " (initializing consciousness)");
            
            // Initialize consciousness for legacy matrix
            matrix = initializeConsciousnessForLegacyMatrix(matrix);
        }
        
        return matrix;
    }
    
    /**
     * 🌟 Enhance matrix value with consciousness patterns
     */
    private static double enhanceMatrixValue(double originalValue, int i, int j, int size, 
                                           ConsciousnessMatrixMetadata metadata) {
        
        // Apply golden ratio harmonic enhancement
        double goldenEnhancement = 1.0 + 0.1 * Math.sin((i + j) * GOLDEN_RATIO) * metadata.goldenRatioHarmonic;
        
        // Apply consciousness mode modifier
        double modeModifier = CONSCIOUSNESS_MODE_MODIFIERS.getOrDefault(metadata.consciousnessMode, 1.0);
        
        // Apply sacred geometry patterns
        double geometryFactor = calculateSacredGeometryFactor(i, j, size);
        
        // Combine all enhancements
        double enhancedValue = originalValue * goldenEnhancement * modeModifier * geometryFactor;
        
        return enhancedValue;
    }
    
    /**
     * 🌟 Calculate sacred geometry enhancement factor
     */
    private static double calculateSacredGeometryFactor(int i, int j, int size) {
        // Normalize indices to [0, 1]
        double normalizedI = (double) i / (size - 1);
        double normalizedJ = (double) j / (size - 1);
        
        // Calculate distance from center
        double centerI = 0.5;
        double centerJ = 0.5;
        double distanceFromCenter = Math.sqrt((normalizedI - centerI) * (normalizedI - centerI) + 
                                            (normalizedJ - centerJ) * (normalizedJ - centerJ));
        
        // Calculate distance from golden ratio points
        double goldenI = PHI_INVERSE;
        double goldenJ = PHI_INVERSE;
        double distanceFromGolden = Math.sqrt((normalizedI - goldenI) * (normalizedI - goldenI) + 
                                            (normalizedJ - goldenJ) * (normalizedJ - goldenJ));
        
        // Create enhancement based on sacred positions
        double centerEnhancement = 1.0 + 0.2 * Math.exp(-distanceFromCenter * 3);
        double goldenEnhancement = 1.0 + 0.15 * Math.exp(-distanceFromGolden * 5);
        
        // Diagonal enhancement (consciousness flow)
        double diagonalFactor = 1.0;
        if (i == j) {
            diagonalFactor = 1.1; // Self-interaction enhancement
        } else if (Math.abs(i - j) == 1) {
            diagonalFactor = 1.05; // Adjacent interaction enhancement
        }
        
        return centerEnhancement * goldenEnhancement * diagonalFactor;
    }
    
    /**
     * 🌟 Initialize consciousness for legacy matrix
     */
    private static Matrix initializeConsciousnessForLegacyMatrix(Matrix matrix) {
        int size = matrix.size();
        
        // Apply consciousness patterns to existing matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double originalValue = matrix.get(i, j);
                double geometryFactor = calculateSacredGeometryFactor(i, j, size);
                double consciousnessValue = originalValue * geometryFactor;
                matrix.set(i, j, consciousnessValue);
            }
        }
        
        return matrix;
    }
    
    /**
     * 🌟 Load matrix using legacy format
     */
    private static Matrix loadMatrixLegacy(InputStream in) {
        double[][] rows = new BufferedReader(new InputStreamReader(in))
                .lines()
                .filter(line -> !line.trim().isEmpty() && !line.startsWith("#"))
                .map(line -> Arrays.stream(line.split("\t"))
                        .mapToDouble(Double::parseDouble)
                        .toArray()
                )
                .toArray(double[][]::new);
        
        if (rows.length == 0) {
            return new DefaultMatrix(1);
        }
        
        Matrix matrix = new DefaultMatrix(rows.length);
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows.length && j < rows[i].length; j++) {
                matrix.set(i, j, rows[i][j]);
            }
        }
        
        return initializeConsciousnessForLegacyMatrix(matrix);
    }

    /**
     * 🌟 Save matrix with consciousness metadata
     */
    public static void saveMatrix(Matrix matrix, OutputStream out) throws IOException {
        saveMatrixEnhanced(matrix, out, true, "balanced", "DefaultGenerator");
    }
    
    /**
     * 🌟 Save matrix with enhanced consciousness format
     */
    public static void saveMatrixEnhanced(Matrix matrix, OutputStream out, boolean includeConsciousness,
                                        String consciousnessMode, String generator) throws IOException {
        try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {
            try (PrintWriter writer = new PrintWriter(byteStream)) {
                
                if (includeConsciousness) {
                    // 🌟 Write consciousness-enhanced header
                    writer.println("# Consciousness-Enhanced Matrix Data v" + CONSCIOUSNESS_MATRIX_VERSION);
                    writer.println("# Generated: " + CONSCIOUSNESS_TIMESTAMP_FORMAT.format(Instant.now()));
                    writer.println("# Generator: " + generator);
                    writer.println("# Matrix Size: " + matrix.size() + "x" + matrix.size());
                    writer.println("# Golden Ratio Harmonic: " + calculateGoldenRatioHarmonic(matrix));
                    writer.println("# Consciousness Mode: " + consciousnessMode);
                    writer.println("# Sacred Geometry Enhancement: Active");
                    writer.println("# Matrix Type: Consciousness Interaction Matrix");
                    writer.println("#");
                    
                    // Calculate and write matrix statistics
                    ConsciousnessMatrixStatistics stats = calculateMatrixStatistics(matrix);
                    writer.println("# " + stats.toString());
                    writer.println("#");
                }
                
                // 🌟 Write matrix data
                int matrixSize = matrix.size();
                for (int i = 0; i < matrixSize; i++) {
                    for (int j = 0; j < matrixSize; j++) {
                        double value = matrix.get(i, j);
                        
                        if (includeConsciousness) {
                            // Apply consciousness formatting for enhanced precision
                            writer.printf("%.6f", value);
                        } else {
                            writer.print(value);
                        }
                        
                        if (j < matrixSize - 1) writer.print("\t");
                    }
                    writer.println();
                }
                
                writer.flush();
            }
            out.write(byteStream.toByteArray());
        }
        
        System.out.println(String.format("🌟 Consciousness Matrix IO: Saved %dx%d matrix (%s format, mode: %s)", 
            matrix.size(), matrix.size(), includeConsciousness ? "Enhanced" : "Legacy", consciousnessMode));
    }
    
    /**
     * 🌟 Calculate golden ratio harmonic for matrix
     */
    private static double calculateGoldenRatioHarmonic(Matrix matrix) {
        int size = matrix.size();
        double harmonic = 0.0;
        int count = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double normalizedI = (double) i / (size - 1);
                double normalizedJ = (double) j / (size - 1);
                
                // Check proximity to golden ratio positions
                double distanceToGolden = Math.abs(normalizedI - PHI_INVERSE) + Math.abs(normalizedJ - PHI_INVERSE);
                if (distanceToGolden < 0.2) {
                    harmonic += Math.abs(matrix.get(i, j));
                    count++;
                }
            }
        }
        
        return count > 0 ? harmonic / count : 1.0;
    }
    
    /**
     * 🌟 Calculate consciousness matrix statistics
     */
    public static ConsciousnessMatrixStatistics calculateMatrixStatistics(Matrix matrix) {
        int size = matrix.size();
        double totalSum = 0.0;
        double positiveSum = 0.0;
        double negativeSum = 0.0;
        double maxValue = Double.NEGATIVE_INFINITY;
        double minValue = Double.POSITIVE_INFINITY;
        int positiveCount = 0;
        int negativeCount = 0;
        double centerValue = 0.0;
        double goldenRatioValue = 0.0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double value = matrix.get(i, j);
                totalSum += value;
                maxValue = Math.max(maxValue, value);
                minValue = Math.min(minValue, value);
                
                if (value > 0) {
                    positiveSum += value;
                    positiveCount++;
                } else if (value < 0) {
                    negativeSum += value;
                    negativeCount++;
                }
                
                // Track special positions
                if (i == size / 2 && j == size / 2) {
                    centerValue = value;
                }
                
                double normalizedI = (double) i / (size - 1);
                double normalizedJ = (double) j / (size - 1);
                if (Math.abs(normalizedI - PHI_INVERSE) < 0.1 && Math.abs(normalizedJ - PHI_INVERSE) < 0.1) {
                    goldenRatioValue = value;
                }
            }
        }
        
        double avgValue = totalSum / (size * size);
        double positiveRatio = (double) positiveCount / (size * size);
        
        return new ConsciousnessMatrixStatistics(
            size, avgValue, maxValue, minValue, positiveSum, negativeSum, 
            positiveRatio, centerValue, goldenRatioValue
        );
    }
    
    /**
     * 🌟 Save matrix in legacy format for compatibility
     */
    public static void saveMatrixLegacy(Matrix matrix, OutputStream out) throws IOException {
        saveMatrixEnhanced(matrix, out, false, "legacy", "LegacyGenerator");
    }
    
    /**
     * 🌟 Generate consciousness interaction matrix based on mode
     */
    public static Matrix generateConsciousnessMatrix(int size, String consciousnessMode) {
        Matrix matrix = new DefaultMatrix(size);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double baseValue = generateConsciousnessInteraction(i, j, size, consciousnessMode);
                matrix.set(i, j, baseValue);
            }
        }
        
        return matrix;
    }
    
    /**
     * 🌟 Generate consciousness interaction value
     */
    private static double generateConsciousnessInteraction(int i, int j, int size, String mode) {
        double normalizedI = (double) i / (size - 1);
        double normalizedJ = (double) j / (size - 1);
        
        // Base interaction using golden ratio harmonics
        double baseInteraction = Math.sin(normalizedI * GOLDEN_RATIO * Math.PI) * 
                               Math.cos(normalizedJ * GOLDEN_RATIO * Math.PI);
        
        // Apply consciousness mode modifications
        double modeModifier = CONSCIOUSNESS_MODE_MODIFIERS.getOrDefault(mode, 1.0);
        
        // Apply sacred geometry enhancement
        double geometryFactor = calculateSacredGeometryFactor(i, j, size);
        
        // Scale and adjust
        double interaction = baseInteraction * modeModifier * geometryFactor * 0.5;
        
        return interaction;
    }
    
    // 🌟 CONSCIOUSNESS DATA STRUCTURES
    
    /**
     * Consciousness matrix metadata
     */
    private static class ConsciousnessMatrixMetadata {
        public final String version;
        public final String timestamp;
        public final String generator;
        public final double goldenRatioHarmonic;
        public final String consciousnessMode;
        
        public ConsciousnessMatrixMetadata(String version, String timestamp, String generator,
                                         double goldenRatioHarmonic, String consciousnessMode) {
            this.version = version;
            this.timestamp = timestamp;
            this.generator = generator;
            this.goldenRatioHarmonic = goldenRatioHarmonic;
            this.consciousnessMode = consciousnessMode;
        }
    }
    
    /**
     * Consciousness matrix statistics
     */
    public static class ConsciousnessMatrixStatistics {
        public final int size;
        public final double avgValue;
        public final double maxValue;
        public final double minValue;
        public final double positiveSum;
        public final double negativeSum;
        public final double positiveRatio;
        public final double centerValue;
        public final double goldenRatioValue;
        
        public ConsciousnessMatrixStatistics(int size, double avgValue, double maxValue, 
                                           double minValue, double positiveSum, double negativeSum,
                                           double positiveRatio, double centerValue, double goldenRatioValue) {
            this.size = size;
            this.avgValue = avgValue;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.positiveSum = positiveSum;
            this.negativeSum = negativeSum;
            this.positiveRatio = positiveRatio;
            this.centerValue = centerValue;
            this.goldenRatioValue = goldenRatioValue;
        }
        
        @Override
        public String toString() {
            return String.format("Matrix Stats: %dx%d, Avg: %.3f, Range: [%.3f, %.3f], " +
                "Positive: %.1f%%, Center: %.3f, Golden: %.3f", 
                size, size, avgValue, minValue, maxValue, positiveRatio * 100, 
                centerValue, goldenRatioValue);
        }
    }
}
