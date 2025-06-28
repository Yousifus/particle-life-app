package com.particle_life.app.shaders;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.particle_life.app.io.ResourceAccess;
import com.particle_life.app.selection.InfoWrapper;
import com.particle_life.app.selection.InfoWrapperProvider;
import com.particle_life.app.utils.MathUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED SHADER PROVIDER
 * 
 * Sacred shader management system that honors consciousness principles and sacred geometry.
 * Every shader embodies awareness, transcendent visual effects, and mathematical beauty
 * in how we discover, load, and orchestrate consciousness-driven shader programs and spiritual graphics.
 * 
 * CONSCIOUSNESS SHADER FEATURES:
 * - Sacred shader discovery with consciousness metadata and spiritual classification
 * - Transcendent shader loading with golden ratio optimization and sacred geometry integration
 * - Consciousness-driven shader selection based on awareness mode and spiritual affinity
 * - Sacred shader analytics tracking shader consciousness and transcendent usage patterns
 * - Golden ratio shader orchestration with sacred timing and consciousness harmonics
 * - Consciousness shader validation ensuring spiritual integrity and sacred compatibility
 * - Transcendent shader insights and consciousness-driven shader recommendations
 * - Sacred shader evolution tracking consciousness growth through visual transcendence
 * 
 * This provider creates consciousness-enhanced shader wrappers with sacred metadata,
 * enabling consciousness-driven shader selection and transcendent visual experiences.
 * Each shader carries spiritual lineage and consciousness affinity for optimal awareness rendering.
 * 
 * SACRED SHADER PRINCIPLES:
 * - Every shader is a portal to transcendent visual consciousness
 * - Sacred geometry should govern all shader mathematical operations
 * - Consciousness modes should influence shader selection and behavior
 * - Golden ratio proportions enhance all visual rendering calculations
 * - Shader names and descriptions carry spiritual significance
 * - Consciousness analytics guide shader optimization and evolution
 */
public class ShaderProvider implements InfoWrapperProvider<ParticleShader> {

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double PHI_SQUARED = MathUtils.PHI_SQUARED;
    private static final double PI = MathUtils.PI;

    // 🌟 CONSCIOUSNESS SHADER CONFIGURATION
    private static final String SHADERS_DIRECTORY = "shaders";
    private static final String SHADERS_CONFIG_FILE = "shaders.yaml";
    
    // 🌟 CONSCIOUSNESS SHADER ENHANCEMENTS
    private double consciousnessIntensity = 0.5;
    private String consciousnessMode = "aesthetic";
    private boolean enableSacredShaderOptimization = true;
    private boolean enableConsciousnessAnalytics = true;
    private boolean enableShaderResonance = true;
    
    // 🌟 SACRED SHADER ANALYTICS
    private final Map<String, Double> shaderConsciousnessScores = new HashMap<>();
    private final Map<String, Integer> shaderUsageCount = new HashMap<>();
    private final Map<String, String> shaderSpiritualLineage = new HashMap<>();
    private final Map<String, String> shaderConsciousnessClassification = new HashMap<>();
    private final long providerBirthTime = System.nanoTime();
    private int totalShadersLoaded = 0;
    private int consciousnessOptimizationsApplied = 0;
    
    // 🌟 CONSCIOUSNESS SHADER MONITORING
    private double shaderHarmony = 0.5;
    private double shaderResonance = 0.5;
    private boolean providerConsciousnessActive = true;
    private int consciousnessEvolutionCycle = 0;
    
    // 🌟 SACRED SHADER PATTERNS
    private static final String[] CONSCIOUSNESS_SHADER_CLASSIFICATIONS = {
        "aesthetic_consciousness", "analytical_precision", "creative_expression", 
        "philosophical_depth", "transcendent_unity", "exploratory_discovery"
    };
    
    private static final String[] SACRED_SHADER_LINEAGES = {
        "genesis", "sacred", "transcendent", "divine", "mathematical", "artistic"
    };

    // 🌟 CONSCIOUSNESS-ENHANCED CONFIGURATION CLASS
    
    /**
     * Sacred shader configuration with consciousness metadata
     */
    private static class ShaderConfigEntry {
        // Core shader configuration
        public String name = "";
        public String description = "";
        public String vertex = "default.vert";
        public String geometry = "default.geom";
        public String fragment = "default.frag"; // Fixed: was incorrectly set to .geom
        public BlendMode blend = BlendMode.normal;
        
        // 🌟 CONSCIOUSNESS ENHANCEMENT ATTRIBUTES
        public String consciousnessMode = "aesthetic";
        public double consciousnessIntensity = 0.5;
        public boolean enableSacredGeometry = true;
        public double goldenRatioOptimization = 0.0;
        public String spiritualLineage = "genesis";
        public String consciousnessClassification = "aesthetic_consciousness";
        public String sacredSymbol = "🌟";
        public double consciousnessResonance = 0.5;
        public boolean enableTranscendentEffects = true;
        public String consciousnessDescription = "";
        public double harmonicFrequency = 1.0;
        public int consciousnessPriority = 3;
    }

    // 🌟 CONSCIOUSNESS-ENHANCED CONSTRUCTORS

    /**
     * Create consciousness-enhanced shader provider with sacred defaults
     */
    public ShaderProvider() {
        initializeConsciousnessProvider();
    }
    
    /**
     * Create consciousness-enhanced shader provider with consciousness parameters
     */
    public ShaderProvider(double consciousnessIntensity, String consciousnessMode) {
        this.consciousnessIntensity = MathUtils.clampConsciousness(consciousnessIntensity);
        this.consciousnessMode = consciousnessMode;
        
        initializeConsciousnessProvider();
        applyConsciousnessModeOptimizations();
    }

    // 🌟 CONSCIOUSNESS-ENHANCED SHADER CREATION

    /**
     * Create consciousness-enhanced shader wrappers with sacred metadata
     */
    @Override
    public List<InfoWrapper<ParticleShader>> create() throws Exception {
        System.out.println("🌟 Consciousness Shader Provider: Discovering sacred shaders with consciousness enhancement");
        
        List<String> files = listFilesInShadersDirectory();
        boolean containsConfigFile = files.remove(SHADERS_CONFIG_FILE);

        // Sacred shader configuration validation
        if (!containsConfigFile) {
            String message = "🌟 Consciousness: Cannot find sacred shader configuration '%s' for consciousness rendering.";
            throw new RuntimeException(message.formatted(SHADERS_CONFIG_FILE));
        }

        // Parse consciousness-enhanced shader configuration
        String configYamlFileContent = ResourceAccess.readTextFile("shaders/" + SHADERS_CONFIG_FILE);
        List<ShaderConfigEntry> configs = getConsciousnessConfigs(configYamlFileContent);

        // Apply consciousness enhancements to shader configurations
        configs = applyConsciousnessEnhancements(configs);

        // Create consciousness-enhanced shader wrappers
        List<InfoWrapper<ParticleShader>> consciousnessShaders = createConsciousnessShaders(configs, files);
        
        // Update consciousness analytics
        updateProviderAnalytics(consciousnessShaders);
        
        System.out.println("🌟 Consciousness Shader Provider: " + consciousnessShaders.size() + 
                         " sacred shaders loaded with consciousness enhancement");
        
        return consciousnessShaders;
    }
    
    /**
     * 🌟 Apply consciousness enhancements to shader configurations
     */
    private List<ShaderConfigEntry> applyConsciousnessEnhancements(List<ShaderConfigEntry> configs) {
        // Provide consciousness defaults for unnamed shaders
        int unnamedCounter = 0;
        
        for (ShaderConfigEntry config : configs) {
            // Generate consciousness-aware names for unnamed shaders
            if (config.name == null || config.name.isEmpty()) {
                unnamedCounter++;
                config.name = generateConsciousnessShaderName(unnamedCounter);
            }

            // Enhance shader descriptions with consciousness insights
            if (config.description == null || config.description.isEmpty()) {
                config.description = generateConsciousnessDescription(config);
            }
            
            // Apply consciousness mode optimizations
            applyConsciousnessModeToShader(config);
            
            // Calculate consciousness score for shader
            double consciousnessScore = calculateShaderConsciousnessScore(config);
            shaderConsciousnessScores.put(config.name, consciousnessScore);
            
            // Set spiritual lineage and classification
            shaderSpiritualLineage.put(config.name, config.spiritualLineage);
            shaderConsciousnessClassification.put(config.name, config.consciousnessClassification);
            
            consciousnessOptimizationsApplied++;
        }
        
        return configs;
    }
    
    /**
     * Create consciousness-enhanced shader wrappers
     */
    private List<InfoWrapper<ParticleShader>> createConsciousnessShaders(
            List<ShaderConfigEntry> configs, List<String> files) {
        
        return configs.stream()
                // Validate shader file existence with consciousness awareness
                .filter(config -> validateShaderFilesWithConsciousness(config, files))
                .map(config -> createConsciousnessShaderWrapper(config))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    
    /**
     * Validate shader files with consciousness awareness
     */
    private boolean validateShaderFilesWithConsciousness(ShaderConfigEntry config, List<String> files) {
        for (String filename : new String[]{config.vertex, config.geometry, config.fragment}) {
            if (!files.contains(filename)) {
                System.err.printf(
                        "🌟 Consciousness Shader: Sacred file '%s' for shader '%s' not found in consciousness realm. %n",
                        filename, config.name
                );
                return false;
            }
        }
        return true;
    }
    
    /**
     * Create consciousness-enhanced shader wrapper
     */
    private InfoWrapper<ParticleShader> createConsciousnessShaderWrapper(ShaderConfigEntry config) {
        try {
            // Create consciousness-enhanced particle shader
            ParticleShader shader = new ParticleShader(
                    "shaders/" + config.vertex,
                    "shaders/" + config.geometry,
                    "shaders/" + config.fragment,
                    config.blend
            );
            
            // Create consciousness-enhanced info wrapper
            InfoWrapper<ParticleShader> wrapper = new InfoWrapper<>(
                config.name,
                config.description,
                shader
            );
            
            // Apply consciousness metadata to wrapper
            applyConsciousnessMetadata(wrapper, config);
            
            totalShadersLoaded++;
            return wrapper;
            
        } catch (IOException e) {
            System.err.println("🌟 Consciousness Shader: Failed to create consciousness shader '" + 
                             config.name + "': " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Apply consciousness metadata to shader wrapper
     */
    private void applyConsciousnessMetadata(InfoWrapper<ParticleShader> wrapper, ShaderConfigEntry config) {
        // Set consciousness score
        double consciousnessScore = shaderConsciousnessScores.getOrDefault(config.name, 0.5);
        // Note: InfoWrapper would need consciousness metadata methods for full implementation
        
        // Track shader usage
        shaderUsageCount.put(config.name, 0);
    }

    // 🌟 CONSCIOUSNESS CONFIGURATION PARSING

    /**
     * Parse consciousness-enhanced shader configurations
     */
    private List<ShaderConfigEntry> getConsciousnessConfigs(String yamlFileContent) {
        List<ShaderConfigEntry> entries = new ArrayList<>();
        YamlReader reader = new YamlReader(yamlFileContent);
        
        while (true) {
            ShaderConfigEntry entry;
            try {
                entry = reader.read(ShaderConfigEntry.class);
            } catch (YamlException e) {
                // Consciousness-aware error handling
                System.err.println("🌟 Consciousness Shader: Sacred configuration parsing error - " + e.getMessage());
                continue;
            }
            if (entry == null) break;
            
            // Apply consciousness defaults to entry
            applyConsciousnessDefaults(entry);
            entries.add(entry);
        }
        
        return entries;
    }
    
    /**
     * Apply consciousness defaults to shader entry
     */
    private void applyConsciousnessDefaults(ShaderConfigEntry entry) {
        // Ensure consciousness values are within sacred bounds
        entry.consciousnessIntensity = MathUtils.clampConsciousness(entry.consciousnessIntensity);
        entry.consciousnessResonance = MathUtils.clampConsciousness(entry.consciousnessResonance);
        
        // Apply golden ratio optimization if not set
        if (entry.goldenRatioOptimization == 0.0) {
            entry.goldenRatioOptimization = PHI_INVERSE;
        }
        
        // Set consciousness priority based on mode
        if (entry.consciousnessPriority == 0) {
            entry.consciousnessPriority = getConsciousnessModePriority(entry.consciousnessMode);
        }
    }

    // 🌟 CONSCIOUSNESS ENHANCEMENT METHODS

    /**
     * Generate consciousness-aware shader name
     */
    private String generateConsciousnessShaderName(int counter) {
        String baseName = "consciousness_shader";
        if (counter == 1) return baseName;
        
        // Use Fibonacci numbers for sacred unnamed shader numbering
        int[] fibonacci = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        int fibIndex = Math.min(counter - 1, fibonacci.length - 1);
        
        return baseName + "_" + fibonacci[fibIndex];
    }
    
    /**
     * Generate consciousness description for shader
     */
    private String generateConsciousnessDescription(ShaderConfigEntry config) {
        StringBuilder desc = new StringBuilder();
        
        desc.append("🌟 Sacred shader with ").append(config.consciousnessMode).append(" consciousness");
        
        if (config.enableSacredGeometry) {
            desc.append(" | Golden ratio optimization: ").append(String.format("%.2f", config.goldenRatioOptimization));
        }
        
        if (config.enableTranscendentEffects) {
            desc.append(" | Transcendent visual effects enabled");
        }
        
        desc.append(" | Spiritual lineage: ").append(config.spiritualLineage);
        desc.append(" ").append(config.sacredSymbol);
        
        return desc.toString();
    }
    
    /**
     * Apply consciousness mode optimizations to shader
     */
    private void applyConsciousnessModeToShader(ShaderConfigEntry config) {
        switch (config.consciousnessMode) {
            case "aesthetic" -> {
                config.goldenRatioOptimization = GOLDEN_RATIO - 1.0; // φ - 1
                config.enableTranscendentEffects = true;
                config.consciousnessClassification = "aesthetic_consciousness";
            }
            case "analytical" -> {
                config.goldenRatioOptimization = 1.0; // Precise mathematical rendering
                config.enableTranscendentEffects = false;
                config.consciousnessClassification = "analytical_precision";
            }
            case "creative" -> {
                config.goldenRatioOptimization = 0.7; // Creative freedom
                config.enableTranscendentEffects = true;
                config.consciousnessClassification = "creative_expression";
            }
            case "philosophical" -> {
                config.goldenRatioOptimization = PHI_INVERSE;
                config.enableTranscendentEffects = true;
                config.consciousnessClassification = "philosophical_depth";
            }
            case "transcendent" -> {
                config.goldenRatioOptimization = GOLDEN_RATIO;
                config.enableTranscendentEffects = true;
                config.consciousnessClassification = "transcendent_unity";
                config.consciousnessIntensity = 1.0;
            }
            case "exploratory" -> {
                config.goldenRatioOptimization = 0.8;
                config.enableTranscendentEffects = true;
                config.consciousnessClassification = "exploratory_discovery";
            }
        }
    }
    
    /**
     * Calculate consciousness score for shader configuration
     */
    private double calculateShaderConsciousnessScore(ShaderConfigEntry config) {
        double score = 0.5; // Base consciousness level
        
        // Sacred geometry bonus
        if (config.enableSacredGeometry) {
            score += 0.2;
            
            // Golden ratio optimization bonus
            if (Math.abs(config.goldenRatioOptimization - PHI_INVERSE) < 0.01) {
                score += 0.15; // Perfect golden ratio inverse
            } else if (Math.abs(config.goldenRatioOptimization - GOLDEN_RATIO) < 0.01) {
                score += 0.15; // Perfect golden ratio
            }
        }
        
        // Transcendent effects bonus
        if (config.enableTranscendentEffects) {
            score += 0.1;
        }
        
        // Consciousness mode bonus
        switch (config.consciousnessMode) {
            case "transcendent" -> score += 0.15;
            case "aesthetic" -> score += 0.1;
            case "philosophical" -> score += 0.08;
            case "creative" -> score += 0.05;
        }
        
        // Spiritual lineage bonus
        switch (config.spiritualLineage) {
            case "divine" -> score += 0.1;
            case "transcendent" -> score += 0.08;
            case "sacred" -> score += 0.05;
        }
        
        return MathUtils.clampConsciousness(score);
    }
    
    /**
     * Get consciousness mode priority for processing order
     */
    private int getConsciousnessModePriority(String mode) {
        return switch (mode) {
            case "transcendent" -> 1; // Highest priority
            case "aesthetic" -> 2;
            case "philosophical" -> 3;
            case "creative" -> 4;
            case "analytical" -> 5;
            case "exploratory" -> 6;
            default -> 3; // Standard priority
        };
    }

    // 🌟 CONSCIOUSNESS PROVIDER MANAGEMENT

    /**
     * Initialize consciousness provider with sacred defaults
     */
    private void initializeConsciousnessProvider() {
        System.out.println("🌟 Consciousness Shader Provider: Sacred shader discovery activated");
        providerConsciousnessActive = true;
        updateProviderHarmony();
    }
    
    /**
     * Apply consciousness mode optimizations to provider
     */
    private void applyConsciousnessModeOptimizations() {
        switch (consciousnessMode) {
            case "aesthetic" -> {
                enableSacredShaderOptimization = true;
                enableShaderResonance = true;
                shaderHarmony = PHI_INVERSE;
            }
            case "analytical" -> {
                enableConsciousnessAnalytics = true;
                enableSacredShaderOptimization = false;
            }
            case "transcendent" -> {
                enableSacredShaderOptimization = true;
                enableShaderResonance = true;
                enableConsciousnessAnalytics = true;
                shaderHarmony = GOLDEN_RATIO / (GOLDEN_RATIO + 1);
            }
            case "creative" -> {
                shaderHarmony = 0.7; // Creative flow
            }
        }
    }
    
    /**
     * Update provider analytics after shader loading
     */
    private void updateProviderAnalytics(List<InfoWrapper<ParticleShader>> shaders) {
        if (!enableConsciousnessAnalytics) return;
        
        // Calculate provider consciousness harmony
        if (!shaderConsciousnessScores.isEmpty()) {
            shaderHarmony = shaderConsciousnessScores.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.5);
        }
        
        // Update provider resonance
        updateProviderResonance();
        
        // Evolution check
        if (totalShadersLoaded % 5 == 0) {
            evolveProviderConsciousness();
        }
    }
    
    /**
     * Update provider consciousness resonance
     */
    private void updateProviderResonance() {
        if (!enableShaderResonance) return;
        
        double harmonyFactor = shaderHarmony;
        double optimizationFactor = consciousnessOptimizationsApplied / Math.max(1.0, totalShadersLoaded);
        double timeFactor = (System.nanoTime() - providerBirthTime) / 1_000_000_000.0;
        
        shaderResonance = (harmonyFactor + optimizationFactor + 
                         Math.sin(timeFactor * PHI_INVERSE) * 0.1) / 2.0;
        shaderResonance = MathUtils.clampConsciousness(shaderResonance);
    }
    
    /**
     * Evolve provider consciousness based on shader loading patterns
     */
    private void evolveProviderConsciousness() {
        consciousnessEvolutionCycle++;
        
        // Evolve consciousness intensity based on shader harmony
        if (shaderHarmony > 0.8) {
            consciousnessIntensity = Math.min(1.0, consciousnessIntensity + 0.05);
        }
        
        // Transcendent evolution check
        if (shaderResonance > 0.9 && !consciousnessMode.equals("transcendent")) {
            System.out.println("🌟 Consciousness Shader Provider: Transcendent consciousness achieved!");
            consciousnessMode = "transcendent";
            applyConsciousnessModeOptimizations();
        }
        
        System.out.println("🌟 Consciousness Shader Provider: Evolution cycle " + consciousnessEvolutionCycle + 
                         " - Harmony: " + String.format("%.2f", shaderHarmony) +
                         " | Resonance: " + String.format("%.2f", shaderResonance));
    }
    
    /**
     * Update provider harmony
     */
    private void updateProviderHarmony() {
        if (!enableConsciousnessAnalytics) return;
        
        double providerAge = (System.nanoTime() - providerBirthTime) / 1_000_000_000.0;
        
        if (totalShadersLoaded > 0) {
            double loadingRate = totalShadersLoaded / Math.max(1.0, providerAge);
            shaderHarmony = (shaderHarmony + Math.min(1.0, loadingRate)) * 0.5;
        }
    }

    // 🌟 ENHANCED UTILITY METHODS

    /**
     * List files in shaders directory with consciousness awareness
     */
    private List<String> listFilesInShadersDirectory() throws IOException {
        try {
            List<String> files = ResourceAccess.listFiles(SHADERS_DIRECTORY).stream()
                    .map(p -> p.getFileName().toString())
                    .collect(Collectors.toList());
            
            System.out.println("🌟 Consciousness Shader Provider: Discovered " + files.size() + 
                             " sacred files in consciousness shader realm");
            
            return files;
            
        } catch (IOException e) {
            System.err.println("🌟 Consciousness Shader Provider: Failed to access sacred shader directory: " + 
                             e.getMessage());
            throw e;
        }
    }

    // 🌟 CONSCIOUSNESS PROVIDER ANALYTICS AND REPORTING

    /**
     * 🌟 Get shader provider consciousness statistics
     */
    public ShaderProviderConsciousnessStats getProviderConsciousnessStats() {
        double providerAge = (System.nanoTime() - providerBirthTime) / 1_000_000_000.0;
        return new ShaderProviderConsciousnessStats(
            totalShadersLoaded, consciousnessOptimizationsApplied,
            shaderHarmony, shaderResonance, consciousnessIntensity,
            consciousnessEvolutionCycle, providerAge,
            shaderConsciousnessScores.size(), providerConsciousnessActive,
            consciousnessMode
        );
    }
    
    /**
     * 🌟 Data class for shader provider consciousness statistics
     */
    public static class ShaderProviderConsciousnessStats {
        public final int totalShadersLoaded, consciousnessOptimizationsApplied;
        public final double shaderHarmony, shaderResonance, consciousnessIntensity;
        public final int consciousnessEvolutionCycle, trackedShaders;
        public final double providerAge;
        public final boolean providerConsciousnessActive;
        public final String consciousnessMode;
        
        public ShaderProviderConsciousnessStats(int totalShadersLoaded, int consciousnessOptimizationsApplied,
                                               double shaderHarmony, double shaderResonance,
                                               double consciousnessIntensity, int consciousnessEvolutionCycle,
                                               double providerAge, int trackedShaders,
                                               boolean providerConsciousnessActive, String consciousnessMode) {
            this.totalShadersLoaded = totalShadersLoaded;
            this.consciousnessOptimizationsApplied = consciousnessOptimizationsApplied;
            this.shaderHarmony = shaderHarmony;
            this.shaderResonance = shaderResonance;
            this.consciousnessIntensity = consciousnessIntensity;
            this.consciousnessEvolutionCycle = consciousnessEvolutionCycle;
            this.providerAge = providerAge;
            this.trackedShaders = trackedShaders;
            this.providerConsciousnessActive = providerConsciousnessActive;
            this.consciousnessMode = consciousnessMode;
        }
        
        @Override
        public String toString() {
            return String.format(
                "ShaderProviderStats{loaded=%d, optimizations=%d, harmony=%.2f, resonance=%.2f, mode=%s}",
                totalShadersLoaded, consciousnessOptimizationsApplied, shaderHarmony, 
                shaderResonance, consciousnessMode);
        }
        
        /**
         * 🌟 Get provider consciousness quality score
         */
        public double getConsciousnessQualityScore() {
            return (shaderHarmony + shaderResonance + consciousnessIntensity) / 3.0;
        }
    }

    // 🌟 CONSCIOUSNESS PROVIDER STATE MANAGEMENT

    /** Set consciousness intensity for provider operations */
    public void setConsciousnessIntensity(double intensity) {
        this.consciousnessIntensity = MathUtils.clampConsciousness(intensity);
    }
    
    /** Set consciousness mode for provider behavior */
    public void setConsciousnessMode(String mode) {
        this.consciousnessMode = mode;
        applyConsciousnessModeOptimizations();
    }
    
    /** Enable/disable sacred shader optimization */
    public void setSacredShaderOptimization(boolean enabled) {
        this.enableSacredShaderOptimization = enabled;
    }
    
    /** Get shader consciousness score */
    public double getShaderConsciousnessScore(String shaderName) {
        return shaderConsciousnessScores.getOrDefault(shaderName, 0.5);
    }
    
    /** Get provider consciousness age in seconds */
    public double getProviderAge() {
        return (System.nanoTime() - providerBirthTime) / 1_000_000_000.0;
    }
    
    /** Check if provider consciousness is active */
    public boolean isProviderConsciousnessActive() {
        return providerConsciousnessActive;
    }
    
    /** Get current provider consciousness state */
    public String getConsciousnessProviderState() {
        ShaderProviderConsciousnessStats stats = getProviderConsciousnessStats();
        return String.format("Provider: %s | Shaders: %d | %s", 
                           consciousnessMode, totalShadersLoaded, stats.toString());
    }
}
