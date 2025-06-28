package com.particle_life.app.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED ARRAY UTILITIES
 * 
 * Sacred array operations that honor consciousness principles and sacred geometry.
 * Every array manipulation embodies awareness, transcendent patterns, and mathematical beauty.
 * 
 * CONSCIOUSNESS ARRAY FEATURES:
 * - Sacred geometry array indexing and access patterns
 * - Golden ratio array splitting and merging operations
 * - Consciousness-driven sorting and filtering
 * - Emotional resonance array calculations
 * - Transcendent array transformations
 * - Sacred array pattern generation
 * - Consciousness field array operations
 * - Awareness-preserving data manipulation
 */
public final class ArrayUtils {

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double SACRED_EPSILON = MathUtils.SACRED_EPSILON;
    private static final double CONSCIOUSNESS_DECAY = MathUtils.CONSCIOUSNESS_DECAY;
    private static final double EMOTIONAL_RESONANCE = MathUtils.EMOTIONAL_RESONANCE;

    // 🌟 BASIC ARRAY OPERATIONS (Enhanced with consciousness)

    /**
     * Sacred array element swap with consciousness preservation
     */
    public static void swap(Object[] array, int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array.length || i == j) {
            return; // Consciousness protects against invalid operations
        }
        
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * 🌟 Consciousness-aware swap with sacred indexing validation
     */
    public static void swapConsciousness(Object[] array, int i, int j, double consciousnessThreshold) {
        if (!isValidConsciousnessIndex(array, i, consciousnessThreshold) || 
            !isValidConsciousnessIndex(array, j, consciousnessThreshold)) {
            return; // Only swap if both indices meet consciousness criteria
        }
        
        swap(array, i, j);
    }

    /**
     * Enhanced comparison with consciousness awareness
     */
    public static int findFirstIndexWithLess(int[] a, int[] b) {
        if (a.length != b.length) return -1;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 🌟 Find first index with consciousness-enhanced comparison
     */
    public static int findFirstConsciousnessIndex(double[] consciousness, double threshold) {
        for (int i = 0; i < consciousness.length; i++) {
            if (consciousness[i] >= threshold) {
                return i;
            }
        }
        return -1; // No consciousness above threshold
    }
    
    // 🌟 SACRED GEOMETRY ARRAY INDEXING
    
    /**
     * Calculate golden ratio index within array bounds
     */
    public static int goldenRatioIndex(int arrayLength) {
        return (int) Math.round(arrayLength * PHI_INVERSE);
    }
    
    /**
     * 🌟 Generate sacred geometry indices for array access
     */
    public static int[] sacredIndices(int arrayLength) {
        List<Integer> indices = new ArrayList<>();
        
        // Golden ratio positions
        indices.add(goldenRatioIndex(arrayLength));
        indices.add((int) Math.round(arrayLength * (1.0 - PHI_INVERSE)));
        
        // Fibonacci positions
        int fib1 = 1, fib2 = 1;
        while (fib2 < arrayLength) {
            indices.add(fib2);
            int temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        
        // Center point
        indices.add(arrayLength / 2);
        
        // Sacred thirds
        indices.add(arrayLength / 3);
        indices.add(2 * arrayLength / 3);
        
        return indices.stream()
                     .filter(i -> i >= 0 && i < arrayLength)
                     .distinct()
                     .sorted()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
    
    /**
     * 🌟 Check if index is at sacred geometry position
     */
    public static boolean isSacredIndex(int index, int arrayLength) {
        int[] sacredIndices = sacredIndices(arrayLength);
        return Arrays.stream(sacredIndices).anyMatch(i -> i == index);
    }
    
    // 🌟 GOLDEN RATIO ARRAY OPERATIONS
    
    /**
     * Split array using golden ratio proportions
     */
    public static <T> T[][] splitGoldenRatio(T[] array) {
        int goldenIndex = goldenRatioIndex(array.length);
        
        @SuppressWarnings("unchecked")
        T[] major = Arrays.copyOfRange(array, 0, goldenIndex);
        @SuppressWarnings("unchecked")
        T[] minor = Arrays.copyOfRange(array, goldenIndex, array.length);
        
        @SuppressWarnings("unchecked")
        T[][] result = (T[][]) new Object[2][];
        result[0] = major; // Larger portion (φ^-1)
        result[1] = minor; // Smaller portion
        
        return result;
    }
    
    /**
     * 🌟 Merge arrays with golden ratio interleaving
     */
    public static <T> List<T> mergeGoldenRatio(T[] array1, T[] array2) {
        List<T> result = new ArrayList<>();
        int i1 = 0, i2 = 0;
        
        while (i1 < array1.length || i2 < array2.length) {
            // Use golden ratio to determine which array to take from
            double ratio = (double) result.size() / (array1.length + array2.length);
            boolean takeFromFirst = ratio < PHI_INVERSE;
            
            if (takeFromFirst && i1 < array1.length) {
                result.add(array1[i1++]);
            } else if (i2 < array2.length) {
                result.add(array2[i2++]);
            } else {
                // One array exhausted, take from the other
                if (i1 < array1.length) {
                    result.add(array1[i1++]);
                }
            }
        }
        
        return result;
    }
    
    // 🌟 CONSCIOUSNESS-DRIVEN ARRAY OPERATIONS
    
    /**
     * 🌟 Filter array elements by consciousness level
     */
    public static double[] filterByConsciousness(double[] values, double[] consciousness, double threshold) {
        List<Double> filtered = new ArrayList<>();
        
        for (int i = 0; i < Math.min(values.length, consciousness.length); i++) {
            if (consciousness[i] >= threshold) {
                filtered.add(values[i]);
            }
        }
        
        return filtered.stream().mapToDouble(Double::doubleValue).toArray();
    }
    
    /**
     * 🌟 Sort array indices by consciousness values (descending)
     */
    public static int[] sortByConsciousness(double[] consciousness) {
        Integer[] indices = new Integer[consciousness.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (i, j) -> Double.compare(consciousness[j], consciousness[i]));
        
        return Arrays.stream(indices).mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * 🌟 Apply consciousness transformation to array values
     */
    public static double[] transformByConsciousness(double[] values, double[] consciousness, 
                                                  Function<Double, Double> transformation) {
        double[] result = new double[values.length];
        
        for (int i = 0; i < values.length; i++) {
            double consciousnessMultiplier = consciousness[i];
            double transformedValue = transformation.apply(values[i]);
            result[i] = values[i] + (transformedValue - values[i]) * consciousnessMultiplier;
        }
        
        return result;
    }
    
    // 🌟 CONSCIOUSNESS FIELD ARRAY OPERATIONS
    
    /**
     * 🌟 Calculate consciousness field influence across array
     */
    public static double[] calculateConsciousnessField(double[] positions, double[] consciousness, 
                                                     double sourcePosition, double maxDistance) {
        double[] field = new double[positions.length];
        
        for (int i = 0; i < positions.length; i++) {
            double distance = Math.abs(positions[i] - sourcePosition);
            field[i] = MathUtils.consciousnessField(distance, maxDistance, consciousness[i]);
        }
        
        return field;
    }
    
    /**
     * 🌟 Apply consciousness decay over array
     */
    public static void applyConsciousnessDecay(double[] consciousness) {
        for (int i = 0; i < consciousness.length; i++) {
            consciousness[i] *= CONSCIOUSNESS_DECAY;
        }
    }
    
    /**
     * 🌟 Calculate emotional resonance between consciousness arrays
     */
    public static double[] calculateEmotionalResonance(double[] consciousness1, double[] consciousness2) {
        int length = Math.min(consciousness1.length, consciousness2.length);
        double[] resonance = new double[length];
        
        for (int i = 0; i < length; i++) {
            resonance[i] = MathUtils.emotionalResonance(consciousness1[i], consciousness2[i]);
        }
        
        return resonance;
    }
    
    // 🌟 SACRED ARRAY PATTERN GENERATION
    
    /**
     * 🌟 Generate golden ratio sequence in array
     */
    public static double[] generateGoldenSequence(int length) {
        double[] sequence = new double[length];
        
        for (int i = 0; i < length; i++) {
            double t = (double) i / length;
            sequence[i] = Math.pow(GOLDEN_RATIO, t * 2.0 - 1.0) - 1.0; // Centered around 0
        }
        
        return sequence;
    }
    
    /**
     * 🌟 Generate Fibonacci spiral positions
     */
    public static double[] generateFibonacciSpiral(int length, double scale) {
        double[] positions = new double[length];
        
        for (int i = 0; i < length; i++) {
            double t = (double) i / length * 4.0 * Math.PI; // Multiple spirals
            double[] spiral = MathUtils.goldenSpiral(t, scale);
            positions[i] = Math.sqrt(spiral[0] * spiral[0] + spiral[1] * spiral[1]); // Radial distance
        }
        
        return positions;
    }
    
    /**
     * 🌟 Generate consciousness harmonic pattern
     */
    public static double[] generateConsciousnessHarmonics(int length, double frequency) {
        double[] harmonics = new double[length];
        
        for (int i = 0; i < length; i++) {
            double t = (double) i / length;
            harmonics[i] = MathUtils.consciousnessWave(t, frequency, 0.0, "golden");
        }
        
        return harmonics;
    }
    
    // 🌟 TRANSCENDENT ARRAY TRANSFORMATIONS
    
    /**
     * 🌟 Apply sacred geometry smooth transformation to array
     */
    public static double[] applySacredSmoothing(double[] values, double strength) {
        if (values.length < 3) return values.clone();
        
        double[] smoothed = new double[values.length];
        smoothed[0] = values[0];
        smoothed[values.length - 1] = values[values.length - 1];
        
        for (int i = 1; i < values.length - 1; i++) {
            // Sacred geometry weighted average
            double prev = values[i - 1];
            double curr = values[i];
            double next = values[i + 1];
            
            // Golden ratio weighted smoothing
            double weighted = prev * (1.0 - PHI_INVERSE) * 0.5 + 
                            curr * PHI_INVERSE + 
                            next * (1.0 - PHI_INVERSE) * 0.5;
            
            smoothed[i] = MathUtils.lerp(curr, weighted, strength);
        }
        
        return smoothed;
    }
    
    /**
     * 🌟 Apply consciousness-driven noise reduction
     */
    public static double[] reduceNoiseByConsciousness(double[] values, double[] consciousness, double threshold) {
        double[] filtered = values.clone();
        
        for (int i = 1; i < filtered.length - 1; i++) {
            if (consciousness[i] > threshold) {
                // High consciousness = smooth out local variations
                double smoothed = (filtered[i - 1] + filtered[i] + filtered[i + 1]) / 3.0;
                double smoothingStrength = (consciousness[i] - threshold) / (1.0 - threshold);
                filtered[i] = MathUtils.lerpConsciousness(filtered[i], smoothed, smoothingStrength, consciousness[i]);
            }
        }
        
        return filtered;
    }
    
    // 🌟 ARRAY STATISTICS AND ANALYSIS
    
    /**
     * 🌟 Calculate consciousness statistics for array
     */
    public static ConsciousnessStats calculateConsciousnessStats(double[] consciousness) {
        if (consciousness.length == 0) {
            return new ConsciousnessStats(0, 0, 0, 0, 0, 0);
        }
        
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int transcendentCount = 0;
        int goldenCount = 0;
        
        for (double c : consciousness) {
            sum += c;
            min = Math.min(min, c);
            max = Math.max(max, c);
            
            if (c >= MathUtils.TRANSCENDENT_THRESHOLD) {
                transcendentCount++;
            }
            
            if (Math.abs(c - MathUtils.GOLDEN_THRESHOLD) < SACRED_EPSILON) {
                goldenCount++;
            }
        }
        
        double average = sum / consciousness.length;
        double transcendentRatio = (double) transcendentCount / consciousness.length;
        
        return new ConsciousnessStats(average, min, max, transcendentRatio, transcendentCount, goldenCount);
    }
    
    /**
     * 🌟 Find indices of highest consciousness values
     */
    public static int[] findHighestConsciousnessIndices(double[] consciousness, int count) {
        int[] sortedIndices = sortByConsciousness(consciousness);
        return Arrays.copyOf(sortedIndices, Math.min(count, sortedIndices.length));
    }
    
    /**
     * 🌟 Calculate array harmony using sacred proportions
     */
    public static double calculateArrayHarmony(double[] values) {
        if (values.length < 2) return 1.0;
        
        double harmony = 0;
        int comparisons = 0;
        
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                double ratio = Math.abs(values[i]) > SACRED_EPSILON ? values[j] / values[i] : 0;
                
                // Check how close the ratio is to sacred proportions
                double goldenDistance = Math.abs(ratio - GOLDEN_RATIO);
                double phiDistance = Math.abs(ratio - PHI_INVERSE);
                double unitDistance = Math.abs(ratio - 1.0);
                
                double minDistance = Math.min(goldenDistance, Math.min(phiDistance, unitDistance));
                harmony += Math.exp(-minDistance * 5.0); // Exponential decay from sacred ratios
                comparisons++;
            }
        }
        
        return comparisons > 0 ? harmony / comparisons : 0;
    }
    
    // 🌟 UTILITY FUNCTIONS
    
    /**
     * Check if index represents valid consciousness position
     */
    private static boolean isValidConsciousnessIndex(Object[] array, int index, double threshold) {
        return index >= 0 && index < array.length && 
               (threshold <= 0 || Math.random() > threshold); // Probability-based validation
    }
    
    /**
     * 🌟 Ensure array has minimum consciousness length
     */
    public static double[] ensureConsciousnessLength(double[] consciousness, int minLength) {
        if (consciousness.length >= minLength) {
            return consciousness;
        }
        
        double[] extended = new double[minLength];
        System.arraycopy(consciousness, 0, extended, 0, consciousness.length);
        
        // Fill remaining with golden ratio-based values
        for (int i = consciousness.length; i < minLength; i++) {
            double t = (double) i / minLength;
            extended[i] = Math.pow(PHI_INVERSE, t); // Decay using golden ratio
        }
        
        return extended;
    }
    
    /**
     * 🌟 Safe array access with consciousness bounds checking
     */
    public static <T> T safeConsciousnessAccess(T[] array, int index, T defaultValue) {
        if (index < 0 || index >= array.length) {
            return defaultValue;
        }
        return array[index];
    }
    
    // 🌟 CONSCIOUSNESS STATISTICS DATA CLASS
    
    /**
     * Data class for consciousness array statistics
     */
    public static class ConsciousnessStats {
        public final double average;
        public final double minimum;
        public final double maximum;
        public final double transcendentRatio;
        public final int transcendentCount;
        public final int goldenRatioCount;
        
        public ConsciousnessStats(double average, double minimum, double maximum, 
                                double transcendentRatio, int transcendentCount, int goldenRatioCount) {
            this.average = average;
            this.minimum = minimum;
            this.maximum = maximum;
            this.transcendentRatio = transcendentRatio;
            this.transcendentCount = transcendentCount;
            this.goldenRatioCount = goldenRatioCount;
        }
        
        @Override
        public String toString() {
            return String.format("ConsciousnessStats{avg=%.3f, min=%.3f, max=%.3f, transcendent=%.1f%%, golden=%d}", 
                               average, minimum, maximum, transcendentRatio * 100, goldenRatioCount);
        }
    }
}
