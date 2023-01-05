package com.example.bonus_laboratory.calculations.surface;

public enum SurfaceType {
        ELLIPSOID("Еліпсоїд"),
        IMAGINARY_ELLIPSOID("Уявний еліпсоїд"),
        ONE_SHEETED_HYPERBOLOID("Однопорожнинний гіперболоїд"),
        TWO_SHEETED_HYPERBOLOID("Двопорожнинний гіперболоїд"),
        CONE("Конус"),
        IMAGINARY_CONE("Уявний конус"),
        ELLIPTICAL_PARABOLOID("Еліптичний параболоїд"),
        HYPERBOLIC_PARABOLOID("Гіперболічний парабалоїд"),
        ELLIPTICAL_CYLINDER("Еліптичний циліндр"),
        PARABOLIC_CYLINDER("Параболічний циліндр"),
        HYPERBOLIC_CYLINDER("Гіперболічний циліндр"),
        IMAGINARY_ELLIPTICAL_CYLINDER("Уявний еліптичний циліндр"),
        PAIR_OF_INTERSECTING_PLANES("Пара перетинаючихся площин"),
        PAIR_OF_IMAGINARY_INTERSECTING_PLANES("Пара уявних перетинаючихся площин"),
        PAIR_OF_PARALLEL_PLANES("Пара паралельних площин"),
        PAIR_OF_IMAGINARY_PARALLEL_PLANES("Пара уявних паралельних площин"),
        PAIR_OF_COINCIDENT_PLANES("Пара співпадаючих площин");

        private final String name;
        SurfaceType(String name){
                this.name = name;
        }

        public String getName() {
                return name;
        }
}


