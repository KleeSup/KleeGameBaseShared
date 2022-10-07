package de.kleesup.libraries.gamebase.shared.random;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * Interface for 3D noise generators.
 * @since 1.0
 */
public interface Noise3D {

    double eval(final double x, final double y, final double z);

}
