export function inspect(
  target: any,
  propertyKey: string,
  descriptor: PropertyDescriptor
) {
  const metodoOriginal = descriptor.value;
  descriptor.value = function(...args: any[]) {
    console.log(`___ Método ${propertyKey}`);
    console.log(`\\_____ Parâmetros: ${JSON.stringify(args)}`);

    const retorno = metodoOriginal.apply(this, args)
    return retorno;
  }
  return descriptor;
}