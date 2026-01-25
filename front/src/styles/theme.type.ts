export interface Theme {
  colors: {
    yellow: string;
    orange: string;
    lightorange: string;
    blue: string;
    green: string;
    lightblue: string;
    purple: string;
    lightyellow: string;
    white: string;
    lightwhite: string;
    black: string;
    gray: {
      [key: number]: string;
    };
  };

  fontSizes: {
    xs: string;
    sm: string;
    base: string;
    lg: string;
    xl: string;
    '2xl': string;
    '3xl': string;
    '4xl': string;
    '5xl': string;
  };

  fontWeights: {
    thin: number;
    light: number;
    regular: number;
    medium: number;
    semibold: number;
    bold: number;
    extrabold: number;
    black: number;
  };

  breakpoints: {
    xs: string;
    sm: string;
    md: string;
    lg: string;
    xl: string;
    '2xl': string;
  };

  spacing: {
    [key: number]: string;
  };

  borderRadius: {
    none: string;
    sm: string;
    base: string;
    md: string;
    lg: string;
    xl: string;
    '2xl': string;
    '3xl': string;
    full: string;
  };

  shadows: {
    sm: string;
    base: string;
    md: string;
    lg: string;
    xl: string;
    '2xl': string;
    inner: string;
    none: string;
  };

  zIndices: {
    hide: number;
    auto: string;
    base: number;
    docked: number;
    dropdown: number;
    sticky: number;
    banner: number;
    overlay: number;
    modal: number;
    popover: number;
    skipLink: number;
    toast: number;
    tooltip: number;
  };
}
