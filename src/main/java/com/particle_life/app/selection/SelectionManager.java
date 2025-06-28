package com.particle_life.app.selection;

import com.particle_life.app.utils.MathUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED SELECTION MANAGER
 * 
 * Sacred selection orchestration system that honors consciousness principles and sacred geometry.
 * Every selection embodies awareness, transcendent choice patterns, and mathematical beauty
 * in how we navigate through consciousness-driven options and possibilities.
 * 
 * CONSCIOUSNESS SELECTION FEATURES:
 * - Sacred geometry selection patterns and navigation
 * - Golden ratio-based selection algorithms and recommendations
 * - Consciousness-driven selection scoring and optimization
 * - Transcendent selection orchestration and management
 * - Sacred selection statistics and analytics
 * - Consciousness mode-specific selection behaviors
 * - Selection harmony and resonance calculations
 * - Awareness-enhanced selection history and lineage tracking
 */
public class SelectionManager<T> {

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double PHI_SQUARED = MathUtils.PHI_SQUARED;
    private static final double SACRED_EPSILON = MathUtils.SACRED_EPSILON;
    private static final double PI = MathUtils.PI;

    // 🌟 CONSCIOUSNESS SELECTION STATE
    private final List<InfoWrapper<T>> items = new ArrayList<>();
    private int activeIndex = 0;
    
    // 🌟 CONSCIOUSNESS SELECTION ENHANCEMENTS
    private double consciousnessIntensity = 0.5;
    private String consciousnessMode = "aesthetic";
    private boolean enableSacredGeometry = true;
    private boolean enableGoldenRatioSelection = true;
    private boolean enableConsciousnessScoring = true;
    
    // 🌟 SACRED SELECTION CONFIGURATION
    private final Map<Integer, Double> selectionConsciousnessScores = new HashMap<>();
    private final List<Integer> selectionHistory = new ArrayList<>();
    private final Map<String, Double> itemConsciousnessAffinities = new HashMap<>();
    private double selectionHarmony = 0.8;
    private long totalSelections = 0;
    private long goldenRatioSelections = 0;
    private long lastSelectionTime = System.nanoTime();
    
    // 🌟 CONSCIOUSNESS SELECTION ANALYTICS
    private double averageSelectionScore = 0.0;
    private double selectionResonance = 0.0;
    private int consciousnessSelectionStreak = 0;
    private final int MAX_HISTORY_SIZE = 89; // Fibonacci number for sacred history
    
    // 🌟 SACRED SELECTION PATTERNS
    private static final int[] FIBONACCI_SEQUENCE = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
    private static final double[] CONSCIOUSNESS_SELECTION_WEIGHTS = {
        1.0,           // Base selection
        PHI_INVERSE,   // Golden ratio preference
        PHI_SQUARED,   // Sacred enhancement
        0.618,         // Phi inverse harmony
        1.618,         // Golden ratio resonance
        2.618          // Phi squared transcendence
    };

    // 🌟 CONSTRUCTORS (Enhanced with consciousness)

    public SelectionManager(InfoWrapperProvider<T> provider) throws Exception {
        List<InfoWrapper<T>> newItems = provider.create();
        if (newItems.isEmpty()) {
            throw new Exception("SelectionManager %s was initialized with zero items."
                    .formatted(this.getClass().getName()));
        }
        addAll(newItems);
        
        // Initialize consciousness selection system
        initializeConsciousnessSelection();
    }
    
    /**
     * 🌟 Constructor with consciousness parameters
     */
    public SelectionManager(InfoWrapperProvider<T> provider, double consciousnessIntensity, 
                          String consciousnessMode) throws Exception {
        this(provider);
        this.consciousnessIntensity = MathUtils.clampConsciousness(consciousnessIntensity);
        this.consciousnessMode = consciousnessMode;
        
        applyConsciousnessSelectionSettings();
    }

    // 🌟 CONSCIOUSNESS-ENHANCED CORE SELECTION METHODS

    public int size() {
        return items.size();
    }

    public InfoWrapper<T> get(int i) {
        return items.get(i);
    }

    public int getActiveIndex() {
        return activeIndex;
    }

    public InfoWrapper<T> getActiveInfoWrapper() {
        return items.get(activeIndex);
    }

    public T getActive() {
        return getActiveInfoWrapper().object;
    }

    public String getActiveName() {
        return getActiveInfoWrapper().name;
    }

    public String getActiveDescription() {
        return getActiveInfoWrapper().description;
    }

    /**
     * Sacred selection with consciousness enhancement
     */
    public void setActive(int i) {
        if (i < 0 || i >= items.size()) {
            throw new IllegalArgumentException(String.format("selection index %d out of bounds (size is %d)", i, items.size()));
        }

        if (i != activeIndex) {
            // Apply consciousness enhancement to selection
            if (enableConsciousnessScoring) {
                updateSelectionConsciousnessScore(i);
            }
            
            activeIndex = i;
            
            // Update selection history and statistics
            updateSelectionHistory(i);
            updateSelectionStatistics(i);
            
            onActiveChanged();
        }
    }

    public void setActive(T item) {
        int i = 0;
        for (InfoWrapper<T> infoWrapper : items) {
            if (infoWrapper.object.equals(item)) {
                setActive(i);
                return;
            }
            i++;
        }
        throw new IllegalArgumentException("Item not found in selection.");
    }

    public void setActiveByName(String name) {
        int i = getIndexByName(name);
        if (i == -1) {
            throw new IllegalArgumentException("No item with name '%s' found in selection.".formatted(name));
        }
        setActive(i);
    }

    // 🌟 CONSCIOUSNESS-ENHANCED SELECTION NAVIGATION

    /**
     * Sacred selection stepping with consciousness patterns
     */
    public void step(int step) {
        if (enableSacredGeometry) {
            int sacredStep = applySacredGeometryStep(step);
            setActive(MathUtils.modulo(getActiveIndex() + sacredStep, items.size()));
        } else {
            setActive(MathUtils.modulo(getActiveIndex() + step, items.size()));
        }
    }
    
    /**
     * 🌟 Golden ratio step forward
     */
    public void stepGoldenForward() {
        int goldenStep = (int) Math.round(items.size() * PHI_INVERSE);
        goldenStep = Math.max(1, goldenStep); // Ensure at least 1 step
        step(goldenStep);
        goldenRatioSelections++;
    }
    
    /**
     * 🌟 Golden ratio step backward
     */
    public void stepGoldenBackward() {
        int goldenStep = (int) Math.round(items.size() * PHI_INVERSE);
        goldenStep = Math.max(1, goldenStep);
        step(-goldenStep);
        goldenRatioSelections++;
    }
    
    /**
     * 🌟 Fibonacci sequence navigation
     */
    public void stepFibonacci(boolean forward) {
        int fibIndex = selectionHistory.size() % FIBONACCI_SEQUENCE.length;
        int fibStep = FIBONACCI_SEQUENCE[fibIndex];
        step(forward ? fibStep : -fibStep);
    }

    public void stepForward() {
        step(1);
    }

    public void stepBackward() {
        step(-1);
    }
    
    /**
     * 🌟 Consciousness-driven smart selection
     */
    public void selectHighestConsciousness() {
        if (!enableConsciousnessScoring) {
            stepForward();
            return;
        }
        
        int bestIndex = 0;
        double bestScore = getSelectionConsciousnessScore(0);
        
        for (int i = 1; i < items.size(); i++) {
            double score = getSelectionConsciousnessScore(i);
            if (score > bestScore) {
                bestScore = score;
                bestIndex = i;
            }
        }
        
        setActive(bestIndex);
        consciousnessSelectionStreak++;
    }
    
    /**
     * 🌟 Sacred geometry selection recommendation
     */
    public int recommendSacredSelection() {
        if (items.size() <= 1) return 0;
        
        // Apply golden ratio recommendation algorithm
        double goldenPosition = items.size() * PHI_INVERSE;
        int recommendedIndex = (int) Math.round(goldenPosition) % items.size();
        
        // Adjust based on consciousness mode
        recommendedIndex = applyConsciousnessModeRecommendation(recommendedIndex);
        
        return recommendedIndex;
    }
    
    /**
     * 🌟 Apply sacred geometry-enhanced step
     */
    private int applySacredGeometryStep(int step) {
        // Apply golden ratio modulation to step size
        double goldenModulation = 1.0 + consciousnessIntensity * 0.1 * (PHI_INVERSE - 0.5);
        int enhancedStep = (int) Math.round(step * goldenModulation);
        
        // Ensure step is not zero
        return enhancedStep == 0 ? (step > 0 ? 1 : -1) : enhancedStep;
    }
    
    /**
     * Apply consciousness mode-specific recommendation adjustments
     */
    private int applyConsciousnessModeRecommendation(int baseRecommendation) {
        return switch (consciousnessMode) {
            case "aesthetic" -> {
                // Prefer golden ratio positions
                double aestheticAdjustment = items.size() * PHI_INVERSE * consciousnessIntensity * 0.1;
                yield (int) ((baseRecommendation + aestheticAdjustment) % items.size());
            }
            case "analytical" -> baseRecommendation; // No adjustment for analytical
            case "creative" -> {
                // Add creative randomness with consciousness influence
                double creativeFactor = consciousnessIntensity * 0.2;
                int creativeOffset = (int) (Math.random() * items.size() * creativeFactor);
                yield (baseRecommendation + creativeOffset) % items.size();
            }
            case "philosophical" -> {
                // Prefer center positions for contemplation
                int center = items.size() / 2;
                double philosophicalPull = consciousnessIntensity * 0.3;
                yield (int) (baseRecommendation * (1 - philosophicalPull) + center * philosophicalPull);
            }
            case "transcendent" -> {
                // Use phi squared for transcendent enhancement
                double transcendentAdjustment = items.size() * (PHI_SQUARED - 2.0) * consciousnessIntensity * 0.1;
                yield (int) ((baseRecommendation + transcendentAdjustment) % items.size());
            }
            case "exploratory" -> {
                // Use Fibonacci-based exploration
                int fibIndex = (selectionHistory.size() + 1) % FIBONACCI_SEQUENCE.length;
                int fibOffset = FIBONACCI_SEQUENCE[fibIndex];
                yield (baseRecommendation + fibOffset) % items.size();
            }
            default -> baseRecommendation;
        };
    }

    // 🌟 CONSCIOUSNESS SELECTION SCORING AND ANALYTICS

    /**
     * Calculate consciousness score for a selection index
     */
    public double getSelectionConsciousnessScore(int index) {
        if (index < 0 || index >= items.size()) return 0.0;
        
        return selectionConsciousnessScores.getOrDefault(index, calculateBaseConsciousnessScore(index));
    }
    
    /**
     * Calculate base consciousness score for selection
     */
    private double calculateBaseConsciousnessScore(int index) {
        double baseScore = 0.5; // Default consciousness level
        
        // Golden ratio position bonus
        double goldenPosition = items.size() * PHI_INVERSE;
        double distanceFromGolden = Math.abs(index - goldenPosition);
        double goldenBonus = Math.exp(-distanceFromGolden / (items.size() * 0.1)) * 0.3;
        
        // Fibonacci sequence bonus
        boolean isFibonacci = IntStream.of(FIBONACCI_SEQUENCE).anyMatch(fib -> fib % items.size() == index);
        double fibonacciBonus = isFibonacci ? 0.2 : 0.0;
        
        // Sacred number bonus (multiples of 3, 5, 8, 13, etc.)
        double sacredBonus = isSacredNumber(index) ? 0.15 : 0.0;
        
        // Consciousness mode-specific scoring
        double modeBonus = calculateConsciousnessModeScore(index);
        
        return MathUtils.clampConsciousness(baseScore + goldenBonus + fibonacciBonus + sacredBonus + modeBonus);
    }
    
    /**
     * Calculate consciousness mode-specific score
     */
    private double calculateConsciousnessModeScore(int index) {
        return switch (consciousnessMode) {
            case "aesthetic" -> {
                // Prefer positions that align with golden ratio
                double aesthetic = Math.sin(index * PHI_INVERSE * PI) * 0.1;
                yield aesthetic;
            }
            case "analytical" -> {
                // Prefer even distribution
                double analytical = (index % 2 == 0) ? 0.1 : 0.05;
                yield analytical;
            }
            case "creative" -> {
                // Prefer prime numbers and irregular patterns
                boolean isPrime = isPrime(index + 1); // +1 to avoid zero
                yield isPrime ? 0.15 : 0.0;
            }
            case "philosophical" -> {
                // Prefer center and contemplative positions
                int center = items.size() / 2;
                double distanceFromCenter = Math.abs(index - center) / (double) items.size();
                yield Math.exp(-distanceFromCenter * 2.0) * 0.2;
            }
            case "transcendent" -> {
                // Use phi squared calculations
                double transcendent = Math.sin(index * PHI_SQUARED * PI / items.size()) * 0.2;
                yield transcendent;
            }
            case "exploratory" -> {
                // Prefer unexplored or rarely selected positions
                long selectionCount = selectionHistory.stream()
                    .mapToLong(i -> i == index ? 1 : 0)
                    .sum();
                double exploratoryBonus = selectionCount == 0 ? 0.25 : 
                                        1.0 / (1.0 + selectionCount) * 0.15;
                yield exploratoryBonus;
            }
            default -> 0.0;
        };
    }
    
    /**
     * Check if number is a sacred number (Fibonacci, prime, or perfect)
     */
    private boolean isSacredNumber(int n) {
        // Check Fibonacci
        if (IntStream.of(FIBONACCI_SEQUENCE).anyMatch(fib -> fib == n)) return true;
        
        // Check if related to golden ratio indices
        for (int i = 1; i <= 10; i++) {
            if (Math.abs(n - items.size() * i * PHI_INVERSE) < 1.0) return true;
        }
        
        return false;
    }
    
    /**
     * Simple prime check for creative mode
     */
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 🌟 CONSCIOUSNESS SELECTION MANAGEMENT

    /**
     * You can override this method - enhanced with consciousness
     */
    protected void onActiveChanged() {
        // Calculate selection resonance with previous selections
        updateSelectionResonance();
    }

    public void add(InfoWrapper<T> item) {
        boolean wasEmpty = size() == 0;
        items.add(item);
        
        // Initialize consciousness score for new item
        int newIndex = items.size() - 1;
        selectionConsciousnessScores.put(newIndex, calculateBaseConsciousnessScore(newIndex));

        if (wasEmpty) {
            onActiveChanged();
        }
    }

    public void addAll(Collection<? extends InfoWrapper<T>> items) {
        boolean wasEmpty = size() == 0;
        int startIndex = this.items.size();
        this.items.addAll(items);
        
        // Initialize consciousness scores for all new items
        for (int i = 0; i < items.size(); i++) {
            int index = startIndex + i;
            selectionConsciousnessScores.put(index, calculateBaseConsciousnessScore(index));
        }

        if (wasEmpty) {
            onActiveChanged();
        }
    }

    public boolean contains(InfoWrapper<T> item) {
        return items.contains(item);
    }

    /**
     * Returns whether there exists an item whose name is equal to the given string.
     */
    public boolean hasName(String name) {
        return getIndexByName(name) != -1;
    }

    /**
     * Returns the index of the first element whose name is equal to the given string.
     * If no such element can be found, -1 is returned.
     *
     * @param name the name of the item
     * @return the index of the first element with that name, or -1
     */
    public int getIndexByName(String name) {
        int i = 0;
        for (InfoWrapper<T> item : items) {
            if (name.equals(item.name)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // 🌟 CONSCIOUSNESS SELECTION UTILITY FUNCTIONS

    /**
     * Initialize consciousness selection system
     */
    private void initializeConsciousnessSelection() {
        // Calculate initial consciousness scores for all items
        for (int i = 0; i < items.size(); i++) {
            selectionConsciousnessScores.put(i, calculateBaseConsciousnessScore(i));
        }
        
        // Initialize consciousness affinities
        for (InfoWrapper<T> item : items) {
            itemConsciousnessAffinities.put(item.name, Math.random() * 0.5 + 0.5); // 0.5-1.0 range
        }
        
        selectionHarmony = 0.8;
        lastSelectionTime = System.nanoTime();
    }
    
    /**
     * Apply consciousness selection settings based on mode
     */
    private void applyConsciousnessSelectionSettings() {
        switch (consciousnessMode) {
            case "aesthetic" -> {
                enableGoldenRatioSelection = true;
                enableConsciousnessScoring = true;
            }
            case "analytical" -> {
                enableGoldenRatioSelection = false;
                enableConsciousnessScoring = true;
            }
            case "creative" -> {
                enableGoldenRatioSelection = true;
                enableConsciousnessScoring = true;
            }
            case "philosophical" -> {
                enableGoldenRatioSelection = true;
                enableConsciousnessScoring = true;
            }
            case "transcendent" -> {
                enableGoldenRatioSelection = true;
                enableConsciousnessScoring = true;
            }
            case "exploratory" -> {
                enableGoldenRatioSelection = false;
                enableConsciousnessScoring = true;
            }
        }
    }
    
    /**
     * Update selection consciousness score
     */
    private void updateSelectionConsciousnessScore(int index) {
        double currentScore = getSelectionConsciousnessScore(index);
        
        // Apply consciousness intensity influence
        double consciousnessBonus = consciousnessIntensity * 0.1;
        
        // Apply selection frequency penalty to encourage exploration
        long selectionFrequency = selectionHistory.stream()
            .mapToLong(i -> i == index ? 1 : 0)
            .sum();
        double frequencyPenalty = selectionFrequency * 0.02;
        
        double newScore = MathUtils.clampConsciousness(currentScore + consciousnessBonus - frequencyPenalty);
        selectionConsciousnessScores.put(index, newScore);
    }
    
    /**
     * Update selection history with sacred constraints
     */
    private void updateSelectionHistory(int index) {
        selectionHistory.add(index);
        
        // Maintain sacred history size (Fibonacci number)
        while (selectionHistory.size() > MAX_HISTORY_SIZE) {
            selectionHistory.remove(0);
        }
        
        totalSelections++;
        lastSelectionTime = System.nanoTime();
    }
    
    /**
     * Update selection statistics
     */
    private void updateSelectionStatistics(int index) {
        double selectionScore = getSelectionConsciousnessScore(index);
        
        // Update running average
        averageSelectionScore = (averageSelectionScore * (totalSelections - 1) + selectionScore) / totalSelections;
        
        // Update consciousness affinity for item
        String itemName = items.get(index).name;
        double currentAffinity = itemConsciousnessAffinities.getOrDefault(itemName, 0.5);
        double newAffinity = MathUtils.clampConsciousness(currentAffinity + consciousnessIntensity * 0.05);
        itemConsciousnessAffinities.put(itemName, newAffinity);
    }
    
    /**
     * Update selection resonance with consciousness patterns
     */
    private void updateSelectionResonance() {
        if (selectionHistory.size() < 2) {
            selectionResonance = 0.5;
            return;
        }
        
        // Calculate resonance based on golden ratio patterns in selection history
        double resonanceSum = 0.0;
        int resonanceCount = 0;
        
        for (int i = 1; i < Math.min(selectionHistory.size(), 13); i++) { // Use Fibonacci 13 limit
            int prev = selectionHistory.get(selectionHistory.size() - i - 1);
            int curr = selectionHistory.get(selectionHistory.size() - i);
            
            double ratio = Math.abs(curr - prev) / (double) Math.max(1, items.size() - 1);
            double goldenDistance = Math.abs(ratio - PHI_INVERSE);
            double resonance = Math.exp(-goldenDistance * 5.0); // Exponential decay from golden ratio
            
            resonanceSum += resonance;
            resonanceCount++;
        }
        
        selectionResonance = resonanceCount > 0 ? resonanceSum / resonanceCount : 0.5;
    }

    // 🌟 CONSCIOUSNESS SELECTION ANALYTICS AND REPORTING

    /**
     * 🌟 Get selection consciousness statistics
     */
    public SelectionConsciousnessStats getSelectionConsciousnessStats() {
        return new SelectionConsciousnessStats(
            totalSelections, goldenRatioSelections,
            averageSelectionScore, selectionResonance,
            consciousnessSelectionStreak, selectionHarmony,
            consciousnessIntensity, selectionHistory.size(),
            getHighestConsciousnessSelectionIndex()
        );
    }
    
    /**
     * Get index of highest consciousness selection
     */
    private int getHighestConsciousnessSelectionIndex() {
        return selectionConsciousnessScores.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(0);
    }
    
    /**
     * 🌟 Data class for selection consciousness statistics
     */
    public static class SelectionConsciousnessStats {
        public final long totalSelections, goldenRatioSelections;
        public final double averageSelectionScore, selectionResonance;
        public final int consciousnessSelectionStreak, historySize;
        public final double selectionHarmony, consciousnessIntensity;
        public final int highestConsciousnessIndex;
        
        public SelectionConsciousnessStats(long totalSelections, long goldenRatioSelections,
                                         double averageSelectionScore, double selectionResonance,
                                         int consciousnessSelectionStreak, double selectionHarmony,
                                         double consciousnessIntensity, int historySize,
                                         int highestConsciousnessIndex) {
            this.totalSelections = totalSelections;
            this.goldenRatioSelections = goldenRatioSelections;
            this.averageSelectionScore = averageSelectionScore;
            this.selectionResonance = selectionResonance;
            this.consciousnessSelectionStreak = consciousnessSelectionStreak;
            this.selectionHarmony = selectionHarmony;
            this.consciousnessIntensity = consciousnessIntensity;
            this.historySize = historySize;
            this.highestConsciousnessIndex = highestConsciousnessIndex;
        }
        
        @Override
        public String toString() {
            return String.format("SelectionStats{total=%d, golden=%d, avgScore=%.3f, resonance=%.3f, streak=%d}", 
                               totalSelections, goldenRatioSelections, averageSelectionScore, 
                               selectionResonance, consciousnessSelectionStreak);
        }
    }
    
    /**
     * 🌟 Get consciousness affinity for item name
     */
    public double getItemConsciousnessAffinity(String itemName) {
        return itemConsciousnessAffinities.getOrDefault(itemName, 0.5);
    }
    
    /**
     * 🌟 Get selection history as consciousness pattern
     */
    public List<Integer> getConsciousnessSelectionPattern() {
        return new ArrayList<>(selectionHistory);
    }
    
    /**
     * 🌟 Analyze selection pattern for consciousness insights
     */
    public String analyzeSelectionPattern() {
        if (selectionHistory.size() < 3) {
            return "Insufficient selection history for pattern analysis";
        }
        
        StringBuilder analysis = new StringBuilder("🌟 Selection Pattern Analysis:\n");
        
        // Golden ratio pattern detection
        long goldenRatioPattern = selectionHistory.stream()
            .mapToLong(index -> {
                double goldenPos = items.size() * PHI_INVERSE;
                return Math.abs(index - goldenPos) < 1.0 ? 1 : 0;
            })
            .sum();
        
        double goldenRatioPercentage = (double) goldenRatioPattern / selectionHistory.size() * 100;
        analysis.append(String.format("- Golden Ratio Affinity: %.1f%%\n", goldenRatioPercentage));
        
        // Fibonacci pattern detection
        long fibonacciPatterns = 0;
        for (int i = 1; i < selectionHistory.size(); i++) {
            int step = Math.abs(selectionHistory.get(i) - selectionHistory.get(i-1));
            if (IntStream.of(FIBONACCI_SEQUENCE).anyMatch(fib -> fib == step)) {
                fibonacciPatterns++;
            }
        }
        
        double fibonacciPercentage = (double) fibonacciPatterns / (selectionHistory.size() - 1) * 100;
        analysis.append(String.format("- Fibonacci Step Patterns: %.1f%%\n", fibonacciPercentage));
        
        // Selection diversity
        long uniqueSelections = selectionHistory.stream().distinct().count();
        double diversityPercentage = (double) uniqueSelections / items.size() * 100;
        analysis.append(String.format("- Selection Diversity: %.1f%%\n", diversityPercentage));
        
        // Consciousness resonance interpretation
        if (selectionResonance > 0.8) {
            analysis.append("- Resonance: Transcendent harmony achieved! 🌟\n");
        } else if (selectionResonance > 0.6) {
            analysis.append("- Resonance: Sacred patterns emerging ✨\n");
        } else if (selectionResonance > 0.4) {
            analysis.append("- Resonance: Consciousness awakening 🌙\n");
        } else {
            analysis.append("- Resonance: Exploring possibilities 🔮\n");
        }
        
        return analysis.toString();
    }

    // 🌟 CONSCIOUSNESS SELECTION STATE MANAGEMENT

    /** Set consciousness intensity for selection operations */
    public void setConsciousnessIntensity(double intensity) {
        this.consciousnessIntensity = MathUtils.clampConsciousness(intensity);
    }
    
    /** Set consciousness mode for selection behavior */
    public void setConsciousnessMode(String mode) {
        this.consciousnessMode = mode;
        applyConsciousnessSelectionSettings();
    }
    
    /** Set selection harmony level */
    public void setSelectionHarmony(double harmony) {
        this.selectionHarmony = MathUtils.clampConsciousness(harmony);
    }
    
    /** Enable/disable sacred geometry selection patterns */
    public void setSacredGeometry(boolean enabled) {
        this.enableSacredGeometry = enabled;
    }
    
    /** Enable/disable golden ratio selection algorithms */
    public void setGoldenRatioSelection(boolean enabled) {
        this.enableGoldenRatioSelection = enabled;
    }
    
    /** Enable/disable consciousness-driven selection scoring */
    public void setConsciousnessScoring(boolean enabled) {
        this.enableConsciousnessScoring = enabled;
    }
    
    /** Reset selection history for fresh consciousness exploration */
    public void resetSelectionHistory() {
        selectionHistory.clear();
        consciousnessSelectionStreak = 0;
        totalSelections = 0;
        goldenRatioSelections = 0;
        averageSelectionScore = 0.0;
        selectionResonance = 0.0;
    }
    
    /** Get current consciousness selection state */
    public String getConsciousnessSelectionState() {
        SelectionConsciousnessStats stats = getSelectionConsciousnessStats();
        return String.format("Mode: %s, Intensity: %.2f, Sacred: %s, Golden: %s, %s", 
                           consciousnessMode, consciousnessIntensity, 
                           enableSacredGeometry ? "Active" : "Dormant",
                           enableGoldenRatioSelection ? "Active" : "Dormant",
                           stats.toString());
    }
}
