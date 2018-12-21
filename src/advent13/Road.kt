package advent13

enum class Road(val symbol: String) {
    VERTICAL("|") {
        override fun move(cart: Cart): Cart {
            if (cart.direction == Direction.DOWN) {
                return Cart(cart.x, cart.y + 1, Direction.DOWN, cart.crossroadCnt)
            } else if (cart.direction == Direction.UP) {
                return Cart(cart.x, cart.y - 1, Direction.UP, cart.crossroadCnt)
            } else {
                return cart
            }
        }
    },
    EMPTY(" ") {
        override fun move(cart: Cart): Cart {
            return cart
        }
    },
    HORIZONTAL("-") {
        override fun move(cart: Cart): Cart {
            if (cart.direction == Direction.RIGHT) {
                return Cart(cart.x + 1, cart.y, Direction.RIGHT, cart.crossroadCnt)
            } else if (cart.direction == Direction.LEFT) {
                return Cart(cart.x - 1, cart.y, Direction.LEFT, cart.crossroadCnt)
            } else {
                return cart
            }
        }
    },
    CROSSROAD("+") {
        override fun move(cart: Cart): Cart {
            val moveCart = moveCart(cart)
            return Cart(moveCart.x, moveCart.y, moveCart.direction, cart.crossroadCnt + 1)
        }

        private fun moveCart(cart: Cart): Cart {
            if (cart.crossroadDirection() == CrossroadDirection.LEFT) {
                if (cart.direction == Direction.UP || cart.direction == Direction.DOWN) {
                    return LEFT.move(cart)
                } else if (cart.direction == Direction.LEFT || cart.direction == Direction.RIGHT) {
                    return RIGHT.move(cart)
                }
            } else if (cart.crossroadDirection() == CrossroadDirection.RIGHT) {
                if (cart.direction == Direction.UP || cart.direction == Direction.DOWN) {
                    return RIGHT.move(cart)
                } else if (cart.direction == Direction.LEFT || cart.direction == Direction.RIGHT) {
                    return LEFT.move(cart)
                }
            } else {
                if (cart.direction == Direction.UP || cart.direction == Direction.DOWN) {
                    return VERTICAL.move(cart)
                } else if (cart.direction == Direction.LEFT || cart.direction == Direction.RIGHT) {
                    return HORIZONTAL.move(cart)
                }
            }
            return EMPTY.move(cart)
        }
    },
    RIGHT("/") {
        override fun move(cart: Cart): Cart {
            if (cart.direction == Direction.UP) {
                return Cart(cart.x + 1, cart.y, Direction.RIGHT, cart.crossroadCnt)
            } else if (cart.direction == Direction.LEFT) {
                return Cart(cart.x, cart.y + 1, Direction.DOWN, cart.crossroadCnt)
            } else if (cart.direction == Direction.DOWN) {
                return Cart(cart.x - 1, cart.y, Direction.LEFT, cart.crossroadCnt)
            } else if (cart.direction == Direction.RIGHT) {
                return Cart(cart.x, cart.y - 1, Direction.UP, cart.crossroadCnt)
            } else {
                return cart
            }
        }
    },
    LEFT("\\") {
        override fun move(cart: Cart): Cart {
            if (cart.direction == Direction.RIGHT) {
                return Cart(cart.x, cart.y + 1, Direction.DOWN, cart.crossroadCnt)
            } else if (cart.direction == Direction.UP) {
                return Cart(cart.x - 1, cart.y, Direction.LEFT, cart.crossroadCnt)
            } else if (cart.direction == Direction.LEFT) {
                return Cart(cart.x, cart.y - 1, Direction.UP, cart.crossroadCnt)
            } else if (cart.direction == Direction.DOWN) {
                return Cart(cart.x + 1, cart.y, Direction.RIGHT, cart.crossroadCnt)
            } else {
                return cart
            }
        }
    };

    abstract fun move(cart: Cart): Cart


    companion object Factory {
        fun from(input: String): Road {
            return Road.values().find { it.symbol.equals(input) } ?: EMPTY
        }
    }
}